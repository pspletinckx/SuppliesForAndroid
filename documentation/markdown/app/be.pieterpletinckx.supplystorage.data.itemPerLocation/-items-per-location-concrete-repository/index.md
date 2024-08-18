//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data.itemPerLocation](../index.md)/[ItemsPerLocationConcreteRepository](index.md)

# ItemsPerLocationConcreteRepository

[androidJvm]\
class [ItemsPerLocationConcreteRepository](index.md)(itemsPerLocationDao: [ItemsPerLocationDao](../-items-per-location-dao/index.md)) : [ItemsPerLocationRepository](../-items-per-location-repository/index.md)

Concrete mapper for ItemsPerLocationRepo

## Constructors

| | |
|---|---|
| [ItemsPerLocationConcreteRepository](-items-per-location-concrete-repository.md) | [androidJvm]<br>constructor(itemsPerLocationDao: [ItemsPerLocationDao](../-items-per-location-dao/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [deleteItem](delete-item.md) | [androidJvm]<br>open suspend override fun [deleteItem](delete-item.md)(item: [ItemsPerLocation](../-items-per-location/index.md)) |
| [getAllItemsStream](get-all-items-stream.md) | [androidJvm]<br>open override fun [getAllItemsStream](get-all-items-stream.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocation](../-items-per-location/index.md)&gt;&gt; |
| [getItemStream](get-item-stream.md) | [androidJvm]<br>open override fun [getItemStream](get-item-stream.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[ItemsPerLocation](../-items-per-location/index.md)?&gt; |
| [insertItem](insert-item.md) | [androidJvm]<br>open suspend override fun [insertItem](insert-item.md)(item: [ItemsPerLocation](../-items-per-location/index.md)) |
| [insertItems](insert-items.md) | [androidJvm]<br>open suspend override fun [insertItems](insert-items.md)(items: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocation](../-items-per-location/index.md)&gt;) |
| [updateItem](update-item.md) | [androidJvm]<br>open suspend override fun [updateItem](update-item.md)(item: [ItemsPerLocation](../-items-per-location/index.md)) |
