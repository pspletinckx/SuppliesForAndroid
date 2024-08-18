package be.pieterpletinckx.supplystorage.data.itemPerLocation

import androidx.room.Embedded
import androidx.room.Relation
import be.pieterpletinckx.supplystorage.data.item.Item
import be.pieterpletinckx.supplystorage.data.location.Location

/**
 * RoomDB Relational class that pulls in both Location and Item objects,
 * Used in multiple DOA depending on QUer
 */
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
) {
    val quantity : Int
        get() = this.itemsPerLocation.quantity
}
