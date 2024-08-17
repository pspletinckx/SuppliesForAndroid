package be.pieterpletinckx.supplystorage.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class Location(
    @PrimaryKey(autoGenerate = true)
    val locationId: Int = 0,
    val locationName: String,
    val parentId : Int? = null,
    val image: String,
)
