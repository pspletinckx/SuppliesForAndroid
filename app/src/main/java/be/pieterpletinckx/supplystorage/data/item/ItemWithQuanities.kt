package be.pieterpletinckx.supplystorage.data.item

import androidx.room.Embedded
import androidx.room.Relation
import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocation

data class ItemWithQuanities(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "itemId",
        entityColumn = "itemId",
    )
    val itemsPerLocation: List<ItemsPerLocation>
)
