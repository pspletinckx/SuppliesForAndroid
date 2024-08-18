//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.ui.item](../index.md)/[ItemEntryViewModel](index.md)

# ItemEntryViewModel

[androidJvm]\
class [ItemEntryViewModel](index.md)(itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md), locationRepository: [LocationRepository](../../be.pieterpletinckx.supplystorage.data.location/-location-repository/index.md), itemsPerLocationRepository: [ItemsPerLocationRepository](../../be.pieterpletinckx.supplystorage.data.itemPerLocation/-items-per-location-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel to validate and insert items in the Room database.

## Constructors

| | |
|---|---|
| [ItemEntryViewModel](-item-entry-view-model.md) | [androidJvm]<br>constructor(itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md), locationRepository: [LocationRepository](../../be.pieterpletinckx.supplystorage.data.location/-location-repository/index.md), itemsPerLocationRepository: [ItemsPerLocationRepository](../../be.pieterpletinckx.supplystorage.data.itemPerLocation/-items-per-location-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [availableLocations](available-locations.md) | [androidJvm]<br>val [availableLocations](available-locations.md): StateFlow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Location](../../be.pieterpletinckx.supplystorage.data.location/-location/index.md)&gt;&gt; |
| [itemUiState](item-ui-state.md) | [androidJvm]<br>var [itemUiState](item-ui-state.md): [ItemUiState](../-item-ui-state/index.md)<br>Holds current item ui state |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [saveItem](save-item.md) | [androidJvm]<br>suspend fun [saveItem](save-item.md)()<br>Inserts an [Item](../../be.pieterpletinckx.supplystorage.data.item/-item/index.md) in the Room database |
| [updateUiState](update-ui-state.md) | [androidJvm]<br>fun [updateUiState](update-ui-state.md)(itemDetails: [ItemDetails](../-item-details/index.md))<br>Updates the [itemUiState](item-ui-state.md) with the value provided in the argument. This method also triggers a validation for input values. |
