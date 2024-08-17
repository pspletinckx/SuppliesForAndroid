package be.pieterpletinckx.supplystorage.data

import kotlinx.coroutines.flow.Flow

class LocationConcreteRepository(private val locationDao: LocationDao) : LocationRepository {
    override fun getAllItemsStream(): Flow<List<Location>> = locationDao.getAllLocations()
}