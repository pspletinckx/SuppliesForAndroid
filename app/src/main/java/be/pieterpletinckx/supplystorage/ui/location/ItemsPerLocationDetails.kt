package be.pieterpletinckx.supplystorage.ui.location

import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemsPerLocation

/**
 * Sanitation class to be use in ItemPerLocation UI elements
 */
data class ItemsPerLocationDetails(
    val itemLocationCrossRefId: Int? =0,
    val locationFkId: Int? = 0,
    val locationName: String = "",
    val quantity: String = "",
)
//fun ItemsPerLocationDetails.toItemsPerLocation(): ItemsPerLocation {
//    ItemsPerLocation(
//        locationFkId= locationFkId?:0,
//        quantity = quantity.toIntOrNull() ?: 0,
//        itemId =
//    )
//}
