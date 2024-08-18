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

package be.pieterpletinckx.supplystorage

import android.content.Context
import androidx.compose.ui.util.fastJoinToString
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import be.pieterpletinckx.supplystorage.data.InventoryDatabase
import be.pieterpletinckx.supplystorage.data.Items.Item
import be.pieterpletinckx.supplystorage.data.Items.ItemDao
import be.pieterpletinckx.supplystorage.data.ItemsPerLocation.ItemsPerLocation
import be.pieterpletinckx.supplystorage.data.ItemsPerLocation.ItemsPerLocationDao
import be.pieterpletinckx.supplystorage.data.Location.Location
import be.pieterpletinckx.supplystorage.data.Location.LocationDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ItemDaoTest {

    private lateinit var itemDao: ItemDao
    private lateinit var locationDao: LocationDao
    private lateinit var itemsPerLocationDao: ItemsPerLocationDao
    private lateinit var inventoryDatabase: InventoryDatabase
    private val location1 = Location(10, "Fruit Basket", image = "image of an Apple")
    private val location2 = Location(20, "Fridge", image = "image of a Banana")
    private val item1 = Item(1, "Apples", 10.0, 20, "Food")
    private val item2 = Item(2, "Bananas", 15.0, 97, "Food")

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        inventoryDatabase = Room.inMemoryDatabaseBuilder(context, InventoryDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        itemDao = inventoryDatabase.itemDao()
        locationDao = inventoryDatabase.locationDao()
        itemsPerLocationDao = inventoryDatabase.itemsPerLocationDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        inventoryDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun daoInsert_insertsItemIntoDB() = runBlocking {
        addOneItemToDb()
        val allItems = itemDao.getAllItems().first()
        assertEquals(allItems[0], item1)
    }

    @Test
    @Throws(Exception::class)
    fun daoGetAllItems_returnsAllItemsFromDB() = runBlocking {
        addTwoItemsToDb()
        val allItems = itemDao.getAllItems().first()
        assertEquals(allItems[0], item1)
        assertEquals(allItems[1], item2)
    }


    @Test
    @Throws(Exception::class)
    fun daoGetItem_returnsItemFromDB() = runBlocking {
        addOneItemToDb()
        val item = itemDao.getItem(1)
        assertEquals(item.first(), item1)
    }

    @Test
    @Throws(Exception::class)
    fun daoDeleteItems_deletesAllItemsFromDB() = runBlocking {
        addTwoItemsToDb()
        itemDao.delete(item1)
        itemDao.delete(item2)
        val allItems = itemDao.getAllItems().first()
        assertTrue(allItems.isEmpty())
    }

    @Test
    @Throws(Exception::class)
    fun daoUpdateItems_updatesItemsInDB() = runBlocking {
        addTwoItemsToDb()
        itemDao.update(Item(1, "Apples", 15.0, 25, "Food"))
        itemDao.update(Item(2, "Bananas", 5.0, 50, "Food"))

        val allItems = itemDao.getAllItems().first()
        assertEquals(allItems[0], Item(1, "Apples", 15.0, 25, "Food"))
        assertEquals(allItems[1], Item(2, "Bananas", 5.0, 50, "Food"))
    }

    private suspend fun addOneItemToDb() {
        itemDao.insert(item1)
    }

    private suspend fun addTwoItemsToDb() {
        itemDao.insert(item1)
        itemDao.insert(item2)
    }

    @Test
    @Throws(Exception::class)
    fun daoGetItemWithLocations_returnsItemFromDB_id() = runBlocking {
        val location1 = Location(10, "Kitchen", image = "image of an Apple")
        val location2 = Location(20, "Storage", image = "image of a Banana")
        val item1 = Item(1, "Apples", 10.0, 20, "Food")
        val item2 = Item(2, "Bananas", 15.0, 97, "Food")

        locationDao.insert(location1)
        locationDao.insert(location2)
        itemDao.insert(item1)
        itemDao.insert(item2)

        itemsPerLocationDao.insert(
            ItemsPerLocation(
                locationFkId = location1.locationId,
                itemId = item2.itemId,
                quantity = 4
            )
        )
        itemsPerLocationDao.insert(
            ItemsPerLocation(
                locationFkId = location1.locationId,
                itemId = item1.itemId,
                quantity = 5
            )
        )
        itemsPerLocationDao.insert(
            ItemsPerLocation(
                locationFkId = location1.locationId,
                itemId = item1.itemId,
                quantity = 4
            )
        )

//        val allItemsPerLocations = itemsPerLocationDao.getItemItemsPerLocation(1).first()
//
//        val debugString =
//            "Locations: " + allItemsPerLocations.map { it.location.locationId }.fastJoinToString() +
//                    "Items: " + allItemsPerLocations.map { it.itemsPerLocation.quantity.toString() + it.item.name }
//                .fastJoinToString()
//
//        Assert.assertEquals(debugString, 2, allItemsPerLocations.size)
//        Assert.assertEquals(
//            debugString,
//            2,
//            allItemsPerLocations.filter { it.item.name == "Apples" }.size
//        )
    }

    @Test
    @Throws(Exception::class)
    fun daoGetItemWithLocations_returnsItemFromDB_id_item() = runBlocking {
        val location1 = Location(10, "Kitchen", image = "image of an Apple")
        val location2 = Location(20, "Storage", image = "image of a Banana")
        val item1 = Item(1, "Apples", 10.0, 20, "Food")
        val item2 = Item(2, "Bananas", 15.0, 97, "Food")

        locationDao.insert(location1)
        locationDao.insert(location2)
        itemDao.insert(item1)
        itemDao.insert(item2)

        itemsPerLocationDao.insert(
            ItemsPerLocation(
                locationFkId = location1.locationId,
                itemId = item2.itemId,
                quantity = 4
            )
        )
        itemsPerLocationDao.insert(
            ItemsPerLocation(
                locationFkId = location1.locationId,
                itemId = item1.itemId,
                quantity = 5
            )
        )
        itemsPerLocationDao.insert(
            ItemsPerLocation(
                locationFkId = location1.locationId,
                itemId = item1.itemId,
                quantity = 4
            )
        )

        val allItemsPerLocations = itemDao.getLocationItemsPerLocation(1).first()

        val debugString =
            "Locations: " + allItemsPerLocations.map { it.location.locationId }.fastJoinToString() +
                    "Items: " + allItemsPerLocations.map { it.itemsPerLocation.quantity.toString() + it.item.name }
                .fastJoinToString()

        Assert.assertEquals(debugString, 2, allItemsPerLocations.size)
        Assert.assertEquals(
            debugString,
            2,
            allItemsPerLocations.filter { it.item.name == "Apples" }.size
        )
    }

    @Test
    @Throws(Exception::class)
    fun daoGetItemWithLocations_returnsItemFromDB_id_itemtest() = runBlocking {
        val location1 = Location(10, "Kitchen", image = "image of an Apple")
        val location2 = Location(20, "Storage", image = "image of a Banana")
        val item1 = Item(0, "Apples", 10.0, 20, "Food")
        val item2 = Item(0, "Bananas", 15.0, 97, "Food")

        locationDao.insert(location1)
        locationDao.insert(location2)
        itemDao.insert(item1)
        itemDao.insert(item2)

        itemsPerLocationDao.insert(
            ItemsPerLocation(
                locationFkId = location1.locationId,
                itemId = item2.itemId,
                quantity = 4
            )
        )
        itemsPerLocationDao.insert(
            ItemsPerLocation(
                locationFkId = location1.locationId,
                itemId = item1.itemId,
                quantity = 5
            )
        )
        itemsPerLocationDao.insert(
            ItemsPerLocation(
                locationFkId = location1.locationId,
                itemId = item1.itemId,
                quantity = 4
            )
        )

        val allItemsPerLocations = itemDao.getLocationItemsPerLocation(1).first()

        val debugString =
            "Locations: " + allItemsPerLocations.map { it.location.locationId }.fastJoinToString() +
                    "Items: " + allItemsPerLocations.map { it.itemsPerLocation.quantity.toString() + it.item.name }
                .fastJoinToString()

        Assert.assertEquals(debugString, 2, allItemsPerLocations.size)
        Assert.assertEquals(
            debugString,
            2,
            allItemsPerLocations.filter { it.item.name == "Apples" }.size
        )
    }

    @Test
    @Throws(Exception::class)
    fun daoGetItemWithLocations_LongReturn() = runBlocking {
        val item1 = Item(1, "Apples", 10.0, 20, "Food")
        val item2 = Item(0, "Bananas", 15.0, 97, "Food")
//        itemDao.insert(item1)
        val insert = itemDao.insert(item1)
        Assert.assertNotNull(insert)
        Assert.assertEquals(1, insert)
        Assert.assertEquals(-1, itemDao.insert(item1))
        Assert.assertEquals(2, itemDao.insert(item2))

    }
}
