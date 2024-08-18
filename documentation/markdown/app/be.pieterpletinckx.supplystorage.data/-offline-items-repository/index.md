//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data](../index.md)/[OfflineItemsRepository](index.md)

# OfflineItemsRepository

[androidJvm]\
class [OfflineItemsRepository](index.md)(itemDao: [ItemDao](../-item-dao/index.md)) : [ItemsRepository](../-items-repository/index.md)

## Constructors

| | |
|---|---|
| [OfflineItemsRepository](-offline-items-repository.md) | [androidJvm]<br>constructor(itemDao: [ItemDao](../-item-dao/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [deleteItem](delete-item.md) | [androidJvm]<br>open suspend override fun [deleteItem](delete-item.md)(item: [Item](../-item/index.md))<br>Delete item from the data source |
| [getAllItemsStream](get-all-items-stream.md) | [androidJvm]<br>open override fun [getAllItemsStream](get-all-items-stream.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Item](../-item/index.md)&gt;&gt;<br>Retrieve all the items from the the given data source. |
| [getItemStream](get-item-stream.md) | [androidJvm]<br>open override fun [getItemStream](get-item-stream.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Item](../-item/index.md)?&gt;<br>Retrieve an item from the given data source that matches with the [id](get-item-stream.md). |
| [getLocationItemsPerLocation](get-location-items-per-location.md) | [androidJvm]<br>open override fun [getLocationItemsPerLocation](get-location-items-per-location.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemPerLocationRel](../-item-per-location-rel/index.md)&gt;&gt; |
| [insertItem](insert-item.md) | [androidJvm]<br>open suspend override fun [insertItem](insert-item.md)(item: [Item](../-item/index.md)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Insert item in the data source |
| [updateItem](update-item.md) | [androidJvm]<br>open suspend override fun [updateItem](update-item.md)(item: [Item](../-item/index.md))<br>Update item in the data source |
