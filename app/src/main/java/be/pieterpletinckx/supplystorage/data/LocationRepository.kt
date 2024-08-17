package be.pieterpletinckx.supplystorage.data

import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getAllItemsStream(): Flow<List<Location>>
}