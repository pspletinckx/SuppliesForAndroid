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

package be.pieterpletinckx.supplystorage.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import be.pieterpletinckx.supplystorage.InventoryApplication
import be.pieterpletinckx.supplystorage.ui.home.HomeViewModel
import be.pieterpletinckx.supplystorage.ui.item.ItemDetailsViewModel
import be.pieterpletinckx.supplystorage.ui.item.ItemEditViewModel
import be.pieterpletinckx.supplystorage.ui.item.ItemEntryViewModel
import be.pieterpletinckx.supplystorage.ui.location.LocationEntryViewModel
import be.pieterpletinckx.supplystorage.ui.search.SearchViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            ItemEntryViewModel(
                inventoryApplication().container.itemsRepository,
                inventoryApplication().container.locationRepository,
                inventoryApplication().container.itemsPerLocationRepository,
            )
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository,
                inventoryApplication().container.itemsPerLocationRepository,
            )
        }

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(inventoryApplication().container.itemsRepository)
        }

        initializer {
            SearchViewModel(
                inventoryApplication().container.itemsRepository,
                inventoryApplication().container.categoryRepository
            )
        }
        initializer {
            LocationEntryViewModel(
                inventoryApplication().container.itemsRepository,
                inventoryApplication().container.locationRepository
            )
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)
