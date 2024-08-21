package be.pieterpletinckx.supplystorage.data.category

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * from category ORDER BY name ASC")
    fun getAllCategories(): Flow<List<Category>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(category: Category) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: List<Category>) : List<Long>

    @Update
    suspend fun update(category: Category)

    @Update
    suspend fun update(category: List<Category>)

    @Delete
    suspend fun delete(category: Category)

    @Query("DELETE FROM category")
    suspend fun deleteAll()
}