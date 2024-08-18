//[app](../../index.md)/[be.pieterpletinckx.supplystorage.data](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AppContainer](-app-container/index.md) | [androidJvm]<br>interface [AppContainer](-app-container/index.md)<br>App container for Dependency injection. |
| [AppDataContainer](-app-data-container/index.md) | [androidJvm]<br>class [AppDataContainer](-app-data-container/index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AppContainer](-app-container/index.md)<br>[AppContainer](-app-container/index.md) implementation that provides instance of [OfflineItemsRepository](../be.pieterpletinckx.supplystorage.data.item/-offline-items-repository/index.md) |
| [Category](-category/index.md) | [androidJvm]<br>data class [Category](-category/index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)val image: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Category Class an Item can belong to , has a 1 to N relationship with Item |
| [Datasource](-datasource/index.md) | [androidJvm]<br>class [Datasource](-datasource/index.md)<br>Serves as the datasource for Category |
| [InventoryDatabase](-inventory-database/index.md) | [androidJvm]<br>abstract class [InventoryDatabase](-inventory-database/index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)<br>Database class with a singleton Instance object. |
