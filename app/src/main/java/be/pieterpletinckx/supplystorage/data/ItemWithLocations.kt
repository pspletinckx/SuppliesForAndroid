package be.pieterpletinckx.supplystorage.data

import androidx.room.Embedded
import androidx.room.Relation

data class ItemWithLocations(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "itemId",
        entityColumn = "itemId"
    )
    val location: List<ItemsPerLocation>
)
