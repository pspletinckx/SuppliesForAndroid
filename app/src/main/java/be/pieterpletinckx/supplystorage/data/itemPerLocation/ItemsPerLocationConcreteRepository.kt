package be.pieterpletinckx.supplystorage.data.itemPerLocation

import kotlinx.coroutines.flow.Flow

/**
 * Concrete mapper for ItemsPerLocationRepo
 */
class ItemsPerLocationConcreteRepository (private val itemsPerLocationDao: ItemsPerLocationDao) :
    ItemsPerLocationRepository {

    override suspend fun insertItem(item: ItemsPerLocation) = itemsPerLocationDao.insert(item)

    override suspend fun insertItems(items: List<ItemsPerLocation>) = itemsPerLocationDao.insert(items)

    override suspend fun deleteItem(item: ItemsPerLocation) = itemsPerLocationDao.delete(item)

    override suspend fun updateItem(item: ItemsPerLocation) = itemsPerLocationDao.update(item)

    override fun getAllItemsStream(): Flow<List<ItemsPerLocation>> = itemsPerLocationDao.getAllLocations()

    override fun getItemsPerLocationByLocation(locationId: Int): Flow<ItemPerLocationRel> = itemsPerLocationDao.getItemsPerLocationByLocation(locationId)

    override fun getItemsPerLocationByItem(itemId: Int): Flow<List<ItemPerLocationRel>> = itemsPerLocationDao.getItemsPerLocationByItem(itemId)
}