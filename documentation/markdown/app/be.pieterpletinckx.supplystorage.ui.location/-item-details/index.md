//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.ui.location](../index.md)/[ItemDetails](index.md)

# ItemDetails

[androidJvm]\
data class [ItemDetails](index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val price: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val quantity: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val location: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)

## Constructors

| | |
|---|---|
| [ItemDetails](-item-details.md) | [androidJvm]<br>constructor(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, price: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, quantity: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, location: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) |

## Properties

| Name | Summary |
|---|---|
| [category](category.md) | [androidJvm]<br>val [category](category.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [location](location.md) | [androidJvm]<br>val [location](location.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [name](name.md) | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [price](price.md) | [androidJvm]<br>val [price](price.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [quantity](quantity.md) | [androidJvm]<br>val [quantity](quantity.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [toItem](../to-item.md) | [androidJvm]<br>fun [ItemDetails](index.md).[toItem](../to-item.md)(): [Item](../../be.pieterpletinckx.supplystorage.data.item/-item/index.md)<br>Extension function to convert [ItemUiState](../-item-ui-state/index.md) to [Item](../../be.pieterpletinckx.supplystorage.data.item/-item/index.md). If the value of [ItemDetails.price](price.md) is not a valid [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), then the price will be set to 0.0. Similarly if the value of [ItemUiState](../-item-ui-state/index.md) is not a valid [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), then the quantity will be set to 0 |
