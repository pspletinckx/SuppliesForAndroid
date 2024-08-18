package be.pieterpletinckx.supplystorage.ui.location

data class ItemsPerLocationDetails(
    val locationFkId: Int? = 0,
    val locationName: String = "",
    val quantity: String = "",
)