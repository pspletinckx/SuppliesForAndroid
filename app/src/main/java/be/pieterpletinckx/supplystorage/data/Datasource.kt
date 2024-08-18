package be.pieterpletinckx.supplystorage.data

import be.pieterpletinckx.supplystorage.R

/**
 * Serves as the datasource for Category
 */
class Datasource() {
    fun loadCategories(): List<Category>{
        return listOf<Category>(
            Category("Drinks", R.drawable.category_drinks_cocktail),
            Category("Food", R.drawable.category_food_canned),
            Category("Cleaning", R.drawable.category_cleaning_spray_soap),
            Category("Bath", R.drawable.category_bath_zen),
            Category("Cooking",R.drawable.category_cooking_pans),
            Category("Electronics", R.drawable.category_electronics_pc),
        )
    }
}