package be.pieterpletinckx.supplystorage.data.ItemsPerLocation

import kotlinx.coroutines.flow.Flow

interface ItemsPerLocationRepository {
    fun getAllItemsStream(): Flow<List<ItemsPerLocation>>

    fun getItemStream(id: Int): Flow<ItemsPerLocation?>

    suspend fun insertItem(item: ItemsPerLocation)

    suspend fun insertItems(items: List<ItemsPerLocation>)

    suspend fun deleteItem(item: ItemsPerLocation)

    suspend fun updateItem(item: ItemsPerLocation)
}