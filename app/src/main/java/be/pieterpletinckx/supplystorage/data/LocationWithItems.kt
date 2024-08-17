package be.pieterpletinckx.supplystorage.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class LocationWithItems (
    @Embedded val location: Location,
    @Relation(
        parentColumn = "locationId",
        entityColumn = "locationFkId",
//        entity = ItemsPerLocation::class
    )
    val numberOfItems: List<ItemsPerLocation>
)

data class SomeOtherObject(
    @Embedded val itemsPerLocation: ItemsPerLocation,
    @Relation(
        parentColumn = "itemId",
        entityColumn = "itemId",
    )
    val item: Item
)

data class NewClass(
    @Embedded val item: Item,
    val number: Item
)