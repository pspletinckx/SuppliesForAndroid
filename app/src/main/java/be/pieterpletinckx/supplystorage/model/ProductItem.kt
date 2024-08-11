package be.pieterpletinckx.supplystorage.model

import java.time.LocalDateTime

/**
 * This class represents properties found on a singular product
 */
data class ProductItem (
    val expiryDate: LocalDateTime,
    val location: String
)