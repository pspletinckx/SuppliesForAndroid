//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data.location](../index.md)/[Location](index.md)

# Location

[androidJvm]\
data class [Location](index.md)(val locationId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val locationName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val parentId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, val image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Location is a physical storage space where you can store ItemPerLocation from Item Eg: This can be a full room, a cabinet, or a single shelve (hence the parent rel) Has an N to 1 relationship with the physical object ItemPerLocation

## Constructors

| | |
|---|---|
| [Location](-location.md) | [androidJvm]<br>constructor(locationId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, locationName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), parentId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [image](image.md) | [androidJvm]<br>val [image](image.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [locationId](location-id.md) | [androidJvm]<br>val [locationId](location-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [locationName](location-name.md) | [androidJvm]<br>val [locationName](location-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [parentId](parent-id.md) | [androidJvm]<br>val [parentId](parent-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |

## Functions

| Name | Summary |
|---|---|
| [toLocationDetails](../../be.pieterpletinckx.supplystorage.ui.location/to-location-details.md) | [androidJvm]<br>fun [Location](index.md).[toLocationDetails](../../be.pieterpletinckx.supplystorage.ui.location/to-location-details.md)(): [LocationDetails](../../be.pieterpletinckx.supplystorage.ui.location/-location-details/index.md) |
| [toLocationUiState](../../be.pieterpletinckx.supplystorage.ui.location/to-location-ui-state.md) | [androidJvm]<br>fun [Location](index.md).[toLocationUiState](../../be.pieterpletinckx.supplystorage.ui.location/to-location-ui-state.md)(isEntryValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [LocationUiState](../../be.pieterpletinckx.supplystorage.ui.location/-location-ui-state/index.md) |
