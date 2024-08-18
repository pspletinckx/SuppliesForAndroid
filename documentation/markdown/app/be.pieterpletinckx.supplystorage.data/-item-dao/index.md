//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data](../index.md)/[ItemDao](index.md)

# ItemDao

[androidJvm]\
interface [ItemDao](index.md)

Database access object to access the Inventory database

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [Item](../-item/index.md)) |
| [getAllItems](get-all-items.md) | [androidJvm]<br>abstract fun [getAllItems](get-all-items.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Item](../-item/index.md)&gt;&gt; |
| [getItem](get-item.md) | [androidJvm]<br>abstract fun [getItem](get-item.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Item](../-item/index.md)&gt; |
| [getLocationItemsPerLocation](get-location-items-per-location.md) | [androidJvm]<br>abstract fun [getLocationItemsPerLocation](get-location-items-per-location.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemPerLocationRel](../-item-per-location-rel/index.md)&gt;&gt; |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [Item](../-item/index.md)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(item: [Item](../-item/index.md)) |
