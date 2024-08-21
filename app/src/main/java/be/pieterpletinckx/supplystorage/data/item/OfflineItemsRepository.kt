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

package be.pieterpletinckx.supplystorage.data.item

import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemPerLocationRel
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocation
import kotlinx.coroutines.flow.Flow

/**
 * Concrete
 */
class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {

    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    override fun getItemsPerLocationByItem(id: Int): Flow<List<ItemPerLocationRel>> = itemDao.getLocationItemsPerLocation(id)

    override suspend fun insertItem(item: Item): Long = itemDao.insert(item)

    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    override suspend fun updateItem(item: Item) = itemDao.update(item)
}
