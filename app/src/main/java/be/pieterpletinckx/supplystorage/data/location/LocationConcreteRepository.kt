package be.pieterpletinckx.supplystorage.data.location

import kotlinx.coroutines.flow.Flow

/**
 * Concrete mapper between the DInjected Interface and the DAO Object for Location
 */
class LocationConcreteRepository(private val locationDao: LocationDao) : LocationRepository {
    override fun getAllItemsStream(): Flow<List<Location>> = locationDao.getAllLocations()

    override suspend fun insertLocation(location: Location) = locationDao.insert(location)
}