//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data.item](../index.md)/[ItemsRepository](index.md)

# ItemsRepository

interface [ItemsRepository](index.md)

Repository that provides insert, update, delete, and retrieve of [Item](../-item/index.md) from a given data source.

#### Inheritors

| |
|---|
| [OfflineItemsRepository](../-offline-items-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [deleteItem](delete-item.md) | [androidJvm]<br>abstract suspend fun [deleteItem](delete-item.md)(item: [Item](../-item/index.md))<br>Delete item from the data source |
| [getAllItemsStream](get-all-items-stream.md) | [androidJvm]<br>abstract fun [getAllItemsStream](get-all-items-stream.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Item](../-item/index.md)&gt;&gt;<br>Retrieve all the items from the the given data source. |
| [getItemStream](get-item-stream.md) | [androidJvm]<br>abstract fun [getItemStream](get-item-stream.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Item](../-item/index.md)?&gt;<br>Retrieve an item from the given data source that matches with the [id](get-item-stream.md). |
| [getLocationItemsPerLocation](get-location-items-per-location.md) | [androidJvm]<br>abstract fun [getLocationItemsPerLocation](get-location-items-per-location.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemPerLocationRel](../../be.pieterpletinckx.supplystorage.data.itemPerLocation/-item-per-location-rel/index.md)&gt;&gt; |
| [insertItem](insert-item.md) | [androidJvm]<br>abstract suspend fun [insertItem](insert-item.md)(item: [Item](../-item/index.md)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Insert item in the data source |
| [updateItem](update-item.md) | [androidJvm]<br>abstract suspend fun [updateItem](update-item.md)(item: [Item](../-item/index.md))<br>Update item in the data source |
