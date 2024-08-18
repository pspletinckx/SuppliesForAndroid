//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data.location](../index.md)/[LocationDao](index.md)

# LocationDao

[androidJvm]\
interface [LocationDao](index.md)

Data access object for Location

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(location: [Location](../-location/index.md)) |
| [getAllLocations](get-all-locations.md) | [androidJvm]<br>abstract fun [getAllLocations](get-all-locations.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Location](../-location/index.md)&gt;&gt; |
| [getItemItemsPerLocation](get-item-items-per-location.md) | [androidJvm]<br>abstract fun [getItemItemsPerLocation](get-item-items-per-location.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemPerLocationRel](../../be.pieterpletinckx.supplystorage.data.itemPerLocation/-item-per-location-rel/index.md)&gt;&gt; |
| [getLocation](get-location.md) | [androidJvm]<br>abstract fun [getLocation](get-location.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Location](../-location/index.md)&gt; |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(location: [Location](../-location/index.md)) |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(location: [Location](../-location/index.md)) |
