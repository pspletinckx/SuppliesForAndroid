package be.pieterpletinckx.supplystorage.data

import kotlinx.coroutines.flow.Flow

class ItemsPerLocationConcreteRepository (private val itemsPerLocationDao: ItemsPerLocationDao) : ItemsPerLocationRepository {
    override fun getAllItemsStream(): Flow<List<ItemsPerLocation>> = itemsPerLocationDao.getAllLocations()

    override fun getItemStream(id: Int): Flow<ItemsPerLocation?> = itemsPerLocationDao.getLocation(id)

    override suspend fun insertItem(item: ItemsPerLocation) = itemsPerLocationDao.insert(item)

    override suspend fun insertItems(items: List<ItemsPerLocation>) = itemsPerLocationDao.insert(items)

    override suspend fun deleteItem(item: ItemsPerLocation) = itemsPerLocationDao.delete(item)

    override suspend fun updateItem(item: ItemsPerLocation) = itemsPerLocationDao.update(item)
}