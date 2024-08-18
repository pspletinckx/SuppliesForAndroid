package be.pieterpletinckx.supplystorage.data.location

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Location is a physical storage space where you can store ItemPerLocation from Item
 * Eg: This can be a full room, a cabinet, or a single shelve (hence the parent rel)
 * Has an N to 1 relationship with the physical object ItemPerLocation
 */
@Entity(tableName = "location")
data class Location(
    @PrimaryKey(autoGenerate = true)
    val locationId: Int = 0,
    val locationName: String,
    val parentId : Int? = null,
    val image: String,
)
