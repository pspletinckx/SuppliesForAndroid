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

package be.pieterpletinckx.supplystorage.data

import android.content.Context
import be.pieterpletinckx.supplystorage.data.category.CategoryApiService
import be.pieterpletinckx.supplystorage.data.category.CategoryCachedRepository
import be.pieterpletinckx.supplystorage.data.category.CategoryDatabaseRepository
import be.pieterpletinckx.supplystorage.data.category.CategoryNetworkRepository
import be.pieterpletinckx.supplystorage.data.category.CategoryRepository
import be.pieterpletinckx.supplystorage.data.item.ItemsRepository
import be.pieterpletinckx.supplystorage.data.item.OfflineItemsRepository
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocationConcreteRepository
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocationRepository
import be.pieterpletinckx.supplystorage.data.location.LocationConcreteRepository
import be.pieterpletinckx.supplystorage.data.location.LocationRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
    val locationRepository: LocationRepository
    val itemsPerLocationRepository: ItemsPerLocationRepository
    val categoryRepository: CategoryRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }

    override val locationRepository: LocationRepository by lazy {
        LocationConcreteRepository(InventoryDatabase.getDatabase(context).locationDao())
    }

    override val itemsPerLocationRepository: ItemsPerLocationRepository by lazy {
        ItemsPerLocationConcreteRepository(InventoryDatabase.getDatabase(context).itemsPerLocationDao())
    }

    override val categoryRepository: CategoryRepository by lazy {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl("https://supplystorage.pieterpletinckx.be/")
            .build()

        val retrofitService: CategoryApiService by lazy {
            retrofit.create(CategoryApiService::class.java)
        }

        CategoryNetworkRepository(retrofitService)

//        CategoryCachedRepository(
//            fastCategoryRepository = CategoryDatabaseRepository(InventoryDatabase.getDatabase(context).categoryDao()),
//            slowCategoryRepository = CategoryNetworkRepository(retrofitService))
    }
}
