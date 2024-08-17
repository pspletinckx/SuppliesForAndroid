package be.pieterpletinckx.supplystorage.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

    @Query("SELECT * from location")
    fun getAllLocations(): Flow<List<Location>>

    @Query("SELECT * from location WHERE locationId = :id")
    fun getLocation(id: Int): Flow<Location>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(location: Location)

    @Update
    suspend fun update(location: Location)

    @Delete
    suspend fun delete(location: Location)

    @Transaction
    @Query("SELECT * FROM location")
    fun getLocationsWithItems(): Flow<List<LocationWithItems>>

    @Transaction
    @Query("SELECT * from location WHERE locationId = :id")
    fun getLocationWithItems(id: Int): Flow<LocationWithItems>
}