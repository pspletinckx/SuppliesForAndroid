package be.pieterpletinckx.supplystorage.ui.location

/**
 * Sanitation class to be use in ItemPerLocation UI elements
 */
data class ItemsPerLocationDetails(
    val locationFkId: Int? = 0,
    val locationName: String = "",
    val quantity: String = "",
)