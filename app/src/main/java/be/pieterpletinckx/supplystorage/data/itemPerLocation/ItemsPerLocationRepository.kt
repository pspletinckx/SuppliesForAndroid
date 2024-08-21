package be.pieterpletinckx.supplystorage.data.itemPerLocation

import kotlinx.coroutines.flow.Flow

/**
 * Interface for ItemsPerLocation as DInjected in the UI
 */
interface ItemsPerLocationRepository {

    suspend fun insertItem(item: ItemsPerLocation)

    suspend fun insertItems(items: List<ItemsPerLocation>)

    suspend fun deleteItem(item: ItemsPerLocation)

    suspend fun updateItem(item: ItemsPerLocation)

    fun getAllItemsStream(): Flow<List<ItemsPerLocation>>

    fun getItemsPerLocationByLocation(locationId: Int): Flow<ItemPerLocationRel>

    fun getItemsPerLocationByItem(itemId: Int): Flow<List<ItemPerLocationRel>>
}