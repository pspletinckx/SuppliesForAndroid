package be.pieterpletinckx.supplystorage.data.location

import kotlinx.coroutines.flow.Flow

/**
 * Interface for Location to be used via DInjection
 */
interface LocationRepository {

    fun getAllItemsStream(): Flow<List<Location>>

    suspend fun insertLocation(toItem: Location)
}