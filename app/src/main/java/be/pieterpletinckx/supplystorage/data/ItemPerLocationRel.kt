package be.pieterpletinckx.supplystorage.data

import androidx.room.Embedded
import androidx.room.Relation

data class ItemPerLocationRel(
    @Embedded val itemsPerLocation: ItemsPerLocation,
    @Relation(
        parentColumn = "locationFkId",
        entityColumn = "locationId",
    )
    val location: Location,
    @Relation(
        parentColumn = "itemId",
        entityColumn = "itemId",
    )
    val item: Item,
)
