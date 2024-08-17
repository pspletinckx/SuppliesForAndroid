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

package be.pieterpletinckx.supplystorage.ui.location

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import be.pieterpletinckx.supplystorage.data.Item
import be.pieterpletinckx.supplystorage.data.ItemsRepository
import be.pieterpletinckx.supplystorage.data.Location
import be.pieterpletinckx.supplystorage.data.LocationRepository
import java.text.NumberFormat

/**
 * ViewModel to validate and insert items in the Room database.
 */
class LocationEntryViewModel(
    private val itemsRepository: ItemsRepository,
    private val locationRepository: LocationRepository) : ViewModel() {

    var locationUiState by mutableStateOf(LocationUiState())
        private set

    fun updateUiState(locationDetails: LocationDetails) {
        locationUiState =  LocationUiState(
            locationDetails = locationDetails,
            isEntryValid = validateInput(locationDetails))
    }

    private fun validateInput(uiState: LocationDetails = locationUiState.locationDetails): Boolean {
        return with(uiState) {
            name.isNotBlank()
        }
    }

    /**
     * Inserts an [Item] in the Room database
     */
    suspend fun saveItem() {
        if (validateInput()) {
            locationRepository.insertLocation(locationUiState.locationDetails.toItem())
        }
    }
}

data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)

data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
    val category: String = "",
    val location: String = "",
)

data class LocationUiState(
    val locationDetails: LocationDetails = LocationDetails(),
    val isEntryValid: Boolean = false
)

data class LocationDetails (
    val id: Int=0,
    val name: String="",
    val parent: String = "",
    val image : String = "",
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
    quantity = quantity.toIntOrNull() ?: 0,
    category = category
)

fun LocationDetails.toItem(): Location = Location(
    locationId = id,
    locationName = name,
    parentId = parent.toIntOrNull() ?: 0,
    image = image
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Item.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

fun Location.toLocationUiState(isEntryValid: Boolean = false): LocationUiState = LocationUiState(
    locationDetails = this.toLocationDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Item.toItemDetails(): ItemDetails = ItemDetails(
    id = itemId,
    name = name,
    price = price.toString(),
    quantity = quantity.toString(),
    category = category
)

fun Location.toLocationDetails(): LocationDetails = LocationDetails(
    id = locationId,
    name = locationName,
    parent = parentId.toString(),
    image = image
)