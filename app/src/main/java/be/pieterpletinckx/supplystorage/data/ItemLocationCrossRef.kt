package be.pieterpletinckx.supplystorage.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["itemId", "locationId"])
data class ItemLocationCrossRef(
    @PrimaryKey(autoGenerate = true)
    val itemLocationCrossRefId: Int = 0,
    val locationId: Int,
    val itemId: Int,
    val number: Int
)