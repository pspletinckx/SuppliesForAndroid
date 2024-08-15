package be.pieterpletinckx.supplystorage.data

import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.model.Category
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
            Category(R.string.category_drinks, R.drawable.category_drinks_cocktail),
            Category(R.string.category_food, R.drawable.category_food_canned),
            Category(R.string.category_cleaning, R.drawable.category_cleaning_spray_soap),
            Category(R.string.category_bath, R.drawable.category_bath_zen),
        )
    }
}