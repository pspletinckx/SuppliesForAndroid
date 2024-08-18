//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.ui.location](../index.md)/[LocationEntryViewModel](index.md)

# LocationEntryViewModel

[androidJvm]\
class [LocationEntryViewModel](index.md)(itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md), locationRepository: [LocationRepository](../../be.pieterpletinckx.supplystorage.data.location/-location-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel to validate and insert items in the Room database.

## Constructors

| | |
|---|---|
| [LocationEntryViewModel](-location-entry-view-model.md) | [androidJvm]<br>constructor(itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md), locationRepository: [LocationRepository](../../be.pieterpletinckx.supplystorage.data.location/-location-repository/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [availableLocations](available-locations.md) | [androidJvm]<br>val [availableLocations](available-locations.md): StateFlow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Location](../../be.pieterpletinckx.supplystorage.data.location/-location/index.md)&gt;&gt; |
| [locationUiState](location-ui-state.md) | [androidJvm]<br>var [locationUiState](location-ui-state.md): [LocationUiState](../-location-ui-state/index.md) |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [saveItem](save-item.md) | [androidJvm]<br>suspend fun [saveItem](save-item.md)()<br>Inserts an [Item](../../be.pieterpletinckx.supplystorage.data.item/-item/index.md) in the Room database |
| [updateUiState](update-ui-state.md) | [androidJvm]<br>fun [updateUiState](update-ui-state.md)(locationDetails: [LocationDetails](../-location-details/index.md)) |
