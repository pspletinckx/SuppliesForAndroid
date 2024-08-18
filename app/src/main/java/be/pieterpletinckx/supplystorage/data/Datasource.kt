package be.pieterpletinckx.supplystorage.data

import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.model.ProductDefinition

class Datasource() {
    fun loadProducts(): List<ProductDefinition> {
        return listOf<ProductDefinition>(
            ProductDefinition(R.string.product_cola, R.drawable.cocacola),
            ProductDefinition(R.string.product_peeled_tomatoes, R.drawable.cocacola),
            ProductDefinition(R.string.product_milk, R.drawable.cocacola),
            ProductDefinition(R.string.product_frozen_beans, R.drawable.cocacola),
            ProductDefinition(R.string.product_chocolate, R.drawable.cocacola),
        )
    }

    fun loadCategories(): List<Category>{
        return listOf<Category>(
            Category("Drinks", R.drawable.category_drinks_cocktail),
            Category("Food", R.drawable.category_food_canned),
            Category("Cleaning", R.drawable.category_cleaning_spray_soap),
            Category("Bath", R.drawable.category_bath_zen),
        )
    }
}