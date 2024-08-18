//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.ui.navigation](../index.md)/[NavigationDestination](index.md)

# NavigationDestination

interface [NavigationDestination](index.md)

Interface to describe the navigation destinations for the app

#### Inheritors

| |
|---|
| [HomeDestination](../../be.pieterpletinckx.supplystorage.ui.home/-home-destination/index.md) |
| [ItemDetailsDestination](../../be.pieterpletinckx.supplystorage.ui.item/-item-details-destination/index.md) |
| [ItemEditDestination](../../be.pieterpletinckx.supplystorage.ui.item/-item-edit-destination/index.md) |
| [ItemEntryDestination](../../be.pieterpletinckx.supplystorage.ui.item/-item-entry-destination/index.md) |
| [LocationEntryDestination](../../be.pieterpletinckx.supplystorage.ui.location/-location-entry-destination/index.md) |
| [SearchByName](../../be.pieterpletinckx.supplystorage.ui.search/-search-by-name/index.md) |

## Properties

| Name | Summary |
|---|---|
| [route](route.md) | [androidJvm]<br>abstract val [route](route.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique name to define the path for a composable |
| [titleRes](title-res.md) | [androidJvm]<br>abstract val [titleRes](title-res.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>String resource id to that contains title to be displayed for the screen. |
