package be.pieterpletinckx.supplystorage.data.ItemsPerLocation

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Number of times and Item is contained in a specific location
 */
@Entity(tableName = "items_per_location")
data class ItemsPerLocation(
    @PrimaryKey(autoGenerate = true)
    val itemLocationCrossRefId: Int = 0,
    val locationFkId: Int,
    val itemId: Int,
    val quantity: Int,
)
