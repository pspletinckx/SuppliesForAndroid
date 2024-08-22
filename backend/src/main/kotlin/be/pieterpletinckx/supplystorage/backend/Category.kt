package be.pieterpletinckx.supplystorage.backend

/**
 * Category Class an Item can belong to ,
 * has a 1 to N relationship with Item
 */


data class Category(
    val name: String,
    val imageUrl: String = ""
)