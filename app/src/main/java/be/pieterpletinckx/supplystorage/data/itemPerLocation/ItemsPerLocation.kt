package be.pieterpletinckx.supplystorage.data.itemPerLocation

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * ItemPerLocation is a physical object that is an Item stored in a Location
 * Has a 1 to N relationship with both Item and Location, whilst adding the field quanity
 */
@Entity(tableName = "items_per_location")
data class ItemsPerLocation(
    @PrimaryKey(autoGenerate = true)
    val itemLocationCrossRefId: Int = 0,
    val locationFkId: Int,
    val itemId: Int,
    val quantity: Int,
)
