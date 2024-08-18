package be.pieterpletinckx.supplystorage.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val name: String,
    @DrawableRes val image: Int,
)
