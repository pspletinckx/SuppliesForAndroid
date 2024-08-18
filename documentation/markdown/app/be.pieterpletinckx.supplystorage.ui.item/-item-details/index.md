//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.ui.item](../index.md)/[ItemDetails](index.md)

# ItemDetails

[androidJvm]\
data class [ItemDetails](index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val price: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val locations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocationDetails](../../be.pieterpletinckx.supplystorage.ui.location/-items-per-location-details/index.md)&gt; = listOf())

## Constructors

| | |
|---|---|
| [ItemDetails](-item-details.md) | [androidJvm]<br>constructor(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, price: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, locations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocationDetails](../../be.pieterpletinckx.supplystorage.ui.location/-items-per-location-details/index.md)&gt; = listOf()) |

## Properties

| Name | Summary |
|---|---|
| [category](category.md) | [androidJvm]<br>val [category](category.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [locations](locations.md) | [androidJvm]<br>val [locations](locations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocationDetails](../../be.pieterpletinckx.supplystorage.ui.location/-items-per-location-details/index.md)&gt; |
| [name](name.md) | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [price](price.md) | [androidJvm]<br>val [price](price.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [toItem](../to-item.md) | [androidJvm]<br>fun [ItemDetails](index.md).[toItem](../to-item.md)(): [Item](../../be.pieterpletinckx.supplystorage.data.item/-item/index.md)<br>Extension function to convert [ItemUiState](../-item-ui-state/index.md) to [Item](../../be.pieterpletinckx.supplystorage.data.item/-item/index.md). If the value of [ItemDetails.price](price.md) is not a valid [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), then the price will be set to 0.0. Similarly if the value of [ItemUiState](../-item-ui-state/index.md) is not a valid [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), then the quantity will be set to 0 |
| [toItemsPerLocations](../to-items-per-locations.md) | [androidJvm]<br>fun [ItemDetails](index.md).[toItemsPerLocations](../to-items-per-locations.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocation](../../be.pieterpletinckx.supplystorage.data.itemPerLocation/-items-per-location/index.md)&gt; |
