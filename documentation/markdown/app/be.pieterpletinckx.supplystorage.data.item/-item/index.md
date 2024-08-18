//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data.item](../index.md)/[Item](index.md)

# Item

[androidJvm]\
data class [Item](index.md)(val itemId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val price: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val quantity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Item is a class representing the definition can have multiple of in your supply storage. Has a 1 to N relationship with a physical ItemPerLocation

## Constructors

| | |
|---|---|
| [Item](-item.md) | [androidJvm]<br>constructor(itemId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), price: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), quantity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [category](category.md) | [androidJvm]<br>val [category](category.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [itemId](item-id.md) | [androidJvm]<br>val [itemId](item-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [name](name.md) | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [price](price.md) | [androidJvm]<br>val [price](price.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [quantity](quantity.md) | [androidJvm]<br>val [quantity](quantity.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [formatedPrice](../../be.pieterpletinckx.supplystorage.ui.item/formated-price.md) | [androidJvm]<br>fun [Item](index.md).[formatedPrice](../../be.pieterpletinckx.supplystorage.ui.item/formated-price.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [toItemDetails](../../be.pieterpletinckx.supplystorage.ui.item/to-item-details.md) | [androidJvm]<br>fun [Item](index.md).[toItemDetails](../../be.pieterpletinckx.supplystorage.ui.item/to-item-details.md)(): [ItemDetails](../../be.pieterpletinckx.supplystorage.ui.item/-item-details/index.md)<br>Extension function to convert [Item](index.md) to [ItemDetails](../../be.pieterpletinckx.supplystorage.ui.item/-item-details/index.md)<br>[androidJvm]<br>fun [Item](index.md).[toItemDetails](../../be.pieterpletinckx.supplystorage.ui.location/to-item-details.md)(): [ItemDetails](../../be.pieterpletinckx.supplystorage.ui.location/-item-details/index.md)<br>Extension function to convert [Item](index.md) to [ItemDetails](../../be.pieterpletinckx.supplystorage.ui.location/-item-details/index.md) |
| [toItemUiState](../../be.pieterpletinckx.supplystorage.ui.item/to-item-ui-state.md) | [androidJvm]<br>fun [Item](index.md).[toItemUiState](../../be.pieterpletinckx.supplystorage.ui.item/to-item-ui-state.md)(isEntryValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [ItemUiState](../../be.pieterpletinckx.supplystorage.ui.item/-item-ui-state/index.md)<br>Extension function to convert [Item](index.md) to [ItemUiState](../../be.pieterpletinckx.supplystorage.ui.item/-item-ui-state/index.md)<br>[androidJvm]<br>fun [Item](index.md).[toItemUiState](../../be.pieterpletinckx.supplystorage.ui.location/to-item-ui-state.md)(isEntryValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [ItemUiState](../../be.pieterpletinckx.supplystorage.ui.location/-item-ui-state/index.md)<br>Extension function to convert [Item](index.md) to [ItemUiState](../../be.pieterpletinckx.supplystorage.ui.location/-item-ui-state/index.md) |
