package be.pieterpletinckx.supplystorage.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Category Class an Item can belong to ,
 * has a 1 to N relationship with Item
 */
data class Category(
    @StringRes val name: String,
    @DrawableRes val image: Int,
)
