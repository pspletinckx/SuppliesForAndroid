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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.pieterpletinckx.supplystorage.data.item.Item
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocation
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocationRepository
import be.pieterpletinckx.supplystorage.data.item.ItemsRepository
import be.pieterpletinckx.supplystorage.data.location.Location
import be.pieterpletinckx.supplystorage.data.location.LocationRepository
import be.pieterpletinckx.supplystorage.ui.location.ItemsPerLocationDetails
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import java.text.NumberFormat

/**
 * ViewModel to validate and insert items in the Room database.
 */
class ItemEntryViewModel(
    private val itemsRepository: ItemsRepository,
    private val locationRepository: LocationRepository,
    private val itemsPerLocationRepository: ItemsPerLocationRepository
) : ViewModel() {


    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val availableLocations: StateFlow<List<Location>> = locationRepository.getAllItemsStream()
    .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
        initialValue = listOf(Location( locationName = "house", image = ""))
    )

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    /**
     * Inserts an [Item] in the Room database
     */
    suspend fun saveItem() {
        if (validateInput()) {
            val generatedId: Long = itemsRepository.insertItem(itemUiState.itemDetails.toItem())
            itemsPerLocationRepository.insertItems(itemUiState.itemDetails.toItemsPerLocations()
                .map { it.copy(itemId = generatedId.toInt()) }
            )
        }
    }

    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
                    name.isNotBlank() &&
                    price.isNotBlank() &&
                    category.isNotBlank() &&
                    locations.isNotEmpty() &&
                    !locations.any { it.quantity.toIntOrNull() == null } &&
                    !locations.any { it.locationFkId == 0 }
        }
    }
}

/**
 * Represents Ui State for an Item.
 */
data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)

data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val category: String = "",
    val locations: List<ItemsPerLocationDetails> = listOf(),
)

/**
 * Extension function to convert [ItemUiState] to [Item]. If the value of [ItemDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [ItemUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun ItemDetails.toItem(): Item = Item(
    itemId = id,
    name = name,
    price = price.toDoubleOrNull() ?: 0.0,
    category = category,
    quantity = locations.map { it.quantity.toIntOrNull() ?: 0 }.sum()
)

fun ItemDetails.toItemsPerLocations(): List<ItemsPerLocation> {
    val templateItem = ItemsPerLocation(itemId = id, locationFkId = 0, quantity = 0)
    return locations.map {
        templateItem.copy(
            locationFkId = it.locationFkId ?: 0,
            quantity = it.quantity.toIntOrNull() ?: 0
        )
    }
}

fun Item.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Item.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Item.toItemDetails(): ItemDetails = ItemDetails(
    id = itemId,
    name = name,
    price = price.toString(),
//    quantity = quantity.toString(),
    category = category
)
