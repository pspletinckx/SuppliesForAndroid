package be.pieterpletinckx.supplystorage.data.ItemsPerLocation

import androidx.room.Embedded
import androidx.room.Relation
import be.pieterpletinckx.supplystorage.data.Items.Item
import be.pieterpletinckx.supplystorage.data.Location.Location

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
