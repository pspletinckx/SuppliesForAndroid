package be.pieterpletinckx.supplystorage.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * This class represents a Type of product which you can have many of
 */
data class ProductDefinition (
    @StringRes val name: Int,
    @DrawableRes val image: Int,
)