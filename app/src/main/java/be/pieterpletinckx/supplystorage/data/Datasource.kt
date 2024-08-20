package be.pieterpletinckx.supplystorage.data

import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.data.category.Category

/**
 * Serves as the datasource for Category
 */
class Datasource() {
    fun loadCategories(): List<Category>{
        return listOf<Category>(
            Category(name = "Drinks", image = R.drawable.category_drinks_cocktail),
            Category(name ="Food", image = R.drawable.category_food_canned),
            Category(name ="Cleaning", image = R.drawable.category_cleaning_spray_soap),
            Category(name ="Bath", image = R.drawable.category_bath_zen),
            Category(name ="Cooking",image = R.drawable.category_cooking_pans),
            Category(name ="Electronics", image = R.drawable.category_electronics_pc),
        )
    }
}