package be.pieterpletinckx.supplystorage.data.Location

import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getAllItemsStream(): Flow<List<Location>>

    suspend fun insertLocation(toItem: Location)
}