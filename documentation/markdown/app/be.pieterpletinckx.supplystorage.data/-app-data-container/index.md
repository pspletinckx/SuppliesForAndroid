//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data](../index.md)/[AppDataContainer](index.md)

# AppDataContainer

[androidJvm]\
class [AppDataContainer](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AppContainer](../-app-container/index.md)

[AppContainer](../-app-container/index.md) implementation that provides instance of [OfflineItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-offline-items-repository/index.md)

## Constructors

| | |
|---|---|
| [AppDataContainer](-app-data-container.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name | Summary |
|---|---|
| [itemsPerLocationRepository](items-per-location-repository.md) | [androidJvm]<br>open override val [itemsPerLocationRepository](items-per-location-repository.md): [ItemsPerLocationRepository](../../be.pieterpletinckx.supplystorage.data.itemPerLocation/-items-per-location-repository/index.md) |
| [itemsRepository](items-repository.md) | [androidJvm]<br>open override val [itemsRepository](items-repository.md): [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)<br>Implementation for [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md) |
| [locationRepository](location-repository.md) | [androidJvm]<br>open override val [locationRepository](location-repository.md): [LocationRepository](../../be.pieterpletinckx.supplystorage.data.location/-location-repository/index.md) |
