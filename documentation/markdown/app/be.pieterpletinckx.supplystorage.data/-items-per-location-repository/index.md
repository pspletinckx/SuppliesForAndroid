//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data](../index.md)/[ItemsPerLocationRepository](index.md)

# ItemsPerLocationRepository

interface [ItemsPerLocationRepository](index.md)

#### Inheritors

| |
|---|
| [ItemsPerLocationConcreteRepository](../-items-per-location-concrete-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [deleteItem](delete-item.md) | [androidJvm]<br>abstract suspend fun [deleteItem](delete-item.md)(item: [ItemsPerLocation](../-items-per-location/index.md)) |
| [getAllItemsStream](get-all-items-stream.md) | [androidJvm]<br>abstract fun [getAllItemsStream](get-all-items-stream.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocation](../-items-per-location/index.md)&gt;&gt; |
| [getItemStream](get-item-stream.md) | [androidJvm]<br>abstract fun [getItemStream](get-item-stream.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[ItemsPerLocation](../-items-per-location/index.md)?&gt; |
| [insertItem](insert-item.md) | [androidJvm]<br>abstract suspend fun [insertItem](insert-item.md)(item: [ItemsPerLocation](../-items-per-location/index.md)) |
| [insertItems](insert-items.md) | [androidJvm]<br>abstract suspend fun [insertItems](insert-items.md)(items: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocation](../-items-per-location/index.md)&gt;) |
| [updateItem](update-item.md) | [androidJvm]<br>abstract suspend fun [updateItem](update-item.md)(item: [ItemsPerLocation](../-items-per-location/index.md)) |
