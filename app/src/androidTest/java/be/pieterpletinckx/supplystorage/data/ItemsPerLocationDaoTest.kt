package be.pieterpletinckx.supplystorage.data

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

import android.content.Context
import androidx.compose.ui.util.fastJoinToString
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import be.pieterpletinckx.supplystorage.data.item.Item
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemPerLocationRel
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocation
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocationDao
import be.pieterpletinckx.supplystorage.data.location.Location
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ItemsPerLocationDaoTest {

    private lateinit var itemsPerLocationDao: ItemsPerLocationDao
    private lateinit var inventoryDatabase: InventoryDatabase

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        inventoryDatabase = Room.inMemoryDatabaseBuilder(context, InventoryDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        itemsPerLocationDao = inventoryDatabase.itemsPerLocationDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        inventoryDatabase.close()
    }


    @Test
    @Throws(Exception::class)
    fun daoGetItemWithLocations_returnsItemFromDB() = runBlocking {
        val location1 = Location(10, "Kitchen", image="image of an Apple")
        val location2 = Location(20, "Storage", image="image of a Banana")
        val item1 = Item(1, "Apples", 10.0, 20, "Food")
        val item2 = Item(2, "Bananas", 15.0, 97, "Food")




//        locationDao.insert(location1)
//        locationDao.insert(location2)
//        itemDao.insert(item1)
//        itemDao.insert(item2)

        itemsPerLocationDao.insert(
            ItemsPerLocation(
            locationFkId =  location1.locationId,
            itemId = item2.itemId,
            quantity = 4)
        )
        itemsPerLocationDao.insert(
            ItemsPerLocation(
            locationFkId =  location1.locationId,
            itemId = item1.itemId,
            quantity = 5)
        )
        itemsPerLocationDao.insert(
            ItemsPerLocation(
            locationFkId =  location1.locationId,
            itemId = item1.itemId,
            quantity = 4)
        )

        val allItemsPerLocations = itemsPerLocationDao.getAllItemsPerLocations().first()

        val debugString =
            "Locations: "+ allItemsPerLocations.map { it.location.locationId }.fastJoinToString() +
                    "Items: "+ allItemsPerLocations.map { it.itemsPerLocation.quantity.toString() + it.item.name}.fastJoinToString ()

        Assert.assertEquals(debugString,3, allItemsPerLocations.size)
        Assert.assertEquals(debugString, 2, allItemsPerLocations.filter {it.item.name == "Apples"}.size)
    }

    @Test
    @Throws(Exception::class)
    fun daoGetItemWithLocations_returnsItemFromDB_col() = runBlocking {
        val location1 = Location(10, "Kitchen", image="image of an Apple")
        val location2 = Location(20, "Storage", image="image of a Banana")
        val item1 = Item(1, "Apples", 10.0, 20, "Food")
        val item2 = Item(2, "Bananas", 15.0, 97, "Food")

        ItemPerLocationRel(
            location = location1,
            item = item1,
            itemsPerLocation = ItemsPerLocation(
                locationFkId =  location1.locationId,
                itemId = item2.itemId,
                quantity = 4
            ))

        val allItemsPerLocations = itemsPerLocationDao.getAllItemsPerLocations().first()

        val debugString =
            "Locations: "+ allItemsPerLocations.map { it.location.locationId }.fastJoinToString() +
                    "Items: "+ allItemsPerLocations.map { it.itemsPerLocation.quantity.toString() + it.item.name}.fastJoinToString ()

        Assert.assertEquals(debugString,1, allItemsPerLocations.size)
//        Assert.assertEquals(debugString, 2, allItemsPerLocations.filter {it.item.name == "Apples"}.size)
//        itemsPerLocationDao.insert(ItemsPerLocation(
//            locationFkId =  location1.locationId,
//            itemId = item2.itemId,
//            quantity = 4))
//        itemsPerLocationDao.insert(ItemsPerLocation(
//            locationFkId =  location1.locationId,
//            itemId = item1.itemId,
//            quantity = 5))
//        itemsPerLocationDao.insert(ItemsPerLocation(
//            locationFkId =  location1.locationId,
//            itemId = item1.itemId,
//            quantity = 4))
//
//        val allItemsPerLocations = itemsPerLocationDao.getAllItemsPerLocations().first()

//        val debugString =
//            "Locations: "+ allItemsPerLocations.map { it.location.locationId }.fastJoinToString() +
//                    "Items: "+ allItemsPerLocations.map { it.itemsPerLocation.quantity.toString() + it.item.name}.fastJoinToString ()
//
//        Assert.assertEquals(debugString,3, allItemsPerLocations.size)
//        Assert.assertEquals(debugString, 2, allItemsPerLocations.filter {it.item.name == "Apples"}.size)
    }
}