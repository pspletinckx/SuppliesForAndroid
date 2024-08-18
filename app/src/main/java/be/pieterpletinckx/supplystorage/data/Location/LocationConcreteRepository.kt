package be.pieterpletinckx.supplystorage.data.Location

import kotlinx.coroutines.flow.Flow

class LocationConcreteRepository(private val locationDao: LocationDao) : LocationRepository {
    override fun getAllItemsStream(): Flow<List<Location>> = locationDao.getAllLocations()

    override suspend fun insertLocation(location: Location) = locationDao.insert(location)
}