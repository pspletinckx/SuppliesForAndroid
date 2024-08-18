package be.pieterpletinckx.supplystorage.data.itemPerLocation

import be.pieterpletinckx.supplystorage.data.item.Item
import be.pieterpletinckx.supplystorage.data.location.Location
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test

/**
 * Test class for ItemPerLocationRel
 */
class ItemPerLocationRelTest {

    /**
     * Quanitity is not a real field but calculated
     */
    @Test
    fun getQuantity() {
        val itemsPerLocation = ItemsPerLocation(itemId = 0, locationFkId = 1, quantity = 2)
        val itemPerLocationRel = ItemPerLocationRel(
            location = Location(locationName = "Kitchen", image = ""),
            item = Item(name = "Milk", category = "Drinks", price = 5.0, quantity = 0),
            itemsPerLocation = itemsPerLocation,
        )
        Assert.assertEquals(itemsPerLocation.quantity, itemPerLocationRel.quantity)
    }
}