/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package be.pieterpletinckx.supplystorage.ui.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.pieterpletinckx.supplystorage.data.item.ItemsRepository
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocation
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocationRepository
import be.pieterpletinckx.supplystorage.ui.location.ItemsPerLocationDetails
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * ViewModel to retrieve, update and delete an item from the [ItemsRepository]'s data source.
 */
class ItemDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository,
    private val itemsPerLocationRepository: ItemsPerLocationRepository
) : ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])

    /**
     * Holds the item details ui state. The data is retrieved from [ItemsRepository] and mapped to
     * the UI state.
     */
    val uiState: StateFlow<ItemDetailsUiState> = itemsPerLocationRepository.getItemsPerLocationByItem(itemId)
        .filterNotNull()
        .filter { it.size > 0 }
        .map { val item = it[0].item
            ItemDetailsUiState(
                outOfStock = it.map { it.itemsPerLocation.quantity }.sum() <= 0, // boolean
                itemDetails = ItemDetails(
                    id = item.itemId,
                    name = item.name,
                    price = item.price.toString(),
                    category = item.category,
                    locations = it.map { location -> ItemsPerLocationDetails(
                            locationFkId = location.location.locationId,
                            locationName = location.location.locationName,
                            itemLocationCrossRefId = location.itemsPerLocation.itemLocationCrossRefId,
                            quantity = location.itemsPerLocation.quantity.toString()) }
                )) //
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = ItemDetailsUiState()
        )

    /**
     * Reduces the item quantity by one and update the [ItemsRepository]'s data source.
     */
    fun reduceQuantityByOne(itemsPerLocationDetails: ItemsPerLocationDetails) {
        viewModelScope.launch {
            val itemsPerLocation = ItemsPerLocation(
                itemLocationCrossRefId = itemsPerLocationDetails.itemLocationCrossRefId?: 0,
                itemId = uiState.value.itemDetails.toItem().itemId,
                locationFkId = itemsPerLocationDetails.locationFkId ?: 0,
                quantity = itemsPerLocationDetails.quantity.toIntOrNull() ?: 0
            )
            if(itemsPerLocation.quantity > 0) {
                itemsPerLocationRepository.updateItem(itemsPerLocation.copy(
                    quantity = itemsPerLocation.quantity - 1)
                )
            }
        }
    }

    fun increaseQuantityByOne(itemsPerLocationDetails: ItemsPerLocationDetails) {
        viewModelScope.launch {
            val itemsPerLocation = ItemsPerLocation(
                itemLocationCrossRefId = itemsPerLocationDetails.itemLocationCrossRefId?: 0,
                itemId = uiState.value.itemDetails.toItem().itemId,
                locationFkId = itemsPerLocationDetails.locationFkId ?: 0,
                quantity = itemsPerLocationDetails.quantity.toIntOrNull() ?: 0
            )
            itemsPerLocationRepository.updateItem(itemsPerLocation.copy(
                quantity = itemsPerLocation.quantity + 1)
            )
        }
    }

    /**
     * Deletes the item from the [ItemsRepository]'s data source.
     */
    suspend fun deleteItem() {
        uiState.value.itemDetails.locations.forEach { itemsPerLocationDetails ->
            itemsPerLocationRepository.deleteItem(ItemsPerLocation(
                itemLocationCrossRefId = itemsPerLocationDetails.itemLocationCrossRefId?: 0,
                itemId = uiState.value.itemDetails.toItem().itemId,
                locationFkId = itemsPerLocationDetails.locationFkId ?: 0,
                quantity = itemsPerLocationDetails.quantity.toIntOrNull() ?: 0
            ))
        }
        itemsRepository.deleteItem(uiState.value.itemDetails.toItem())

    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI state for ItemDetailsScreen
 */
data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val itemDetails: ItemDetails = ItemDetails()
)
