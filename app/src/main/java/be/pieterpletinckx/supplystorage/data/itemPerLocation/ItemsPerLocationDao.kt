package be.pieterpletinckx.supplystorage.data.itemPerLocation

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Data access object of for ItemsPerLocation
 */
@Dao
interface ItemsPerLocationDao {

    @Query("SELECT * from items_per_location")
    fun getAllLocations(): Flow<List<ItemsPerLocation>>

    @Query("SELECT * from items_per_location WHERE itemLocationCrossRefId = :id")
    fun getLocation(id: Int): Flow<ItemsPerLocation>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(itemsPerLocation: ItemsPerLocation)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(itemsPerLocations: List<ItemsPerLocation>)

    @Update
    suspend fun update(location: ItemsPerLocation)

    @Delete
    suspend fun delete(location: ItemsPerLocation)

    @Transaction
    @Query("SELECT * FROM items_per_location")
    fun getAllItemsPerLocations(): Flow<List<ItemPerLocationRel>>

    @Transaction
    @Query("SELECT * FROM items_per_location WHERE locationFkId = :id")
    fun getLocationItemsPerLocation(id: Int): Flow<List<ItemPerLocationRel>>

}