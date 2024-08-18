//[app](../../index.md)/[be.pieterpletinckx.supplystorage.ui.location](index.md)/[toItem](to-item.md)

# toItem

[androidJvm]\
fun [ItemDetails](-item-details/index.md).[toItem](to-item.md)(): [Item](../be.pieterpletinckx.supplystorage.data.item/-item/index.md)

Extension function to convert [ItemUiState](-item-ui-state/index.md) to [Item](../be.pieterpletinckx.supplystorage.data.item/-item/index.md). If the value of [ItemDetails.price](-item-details/price.md) is not a valid [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), then the price will be set to 0.0. Similarly if the value of [ItemUiState](-item-ui-state/index.md) is not a valid [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), then the quantity will be set to 0

[androidJvm]\
fun [LocationDetails](-location-details/index.md).[toItem](to-item.md)(): [Location](../be.pieterpletinckx.supplystorage.data.location/-location/index.md)
