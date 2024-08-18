//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data.itemPerLocation](../index.md)/[ItemsPerLocationDao](index.md)

# ItemsPerLocationDao

[androidJvm]\
interface [ItemsPerLocationDao](index.md)

Data access object of for ItemsPerLocation

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(location: [ItemsPerLocation](../-items-per-location/index.md)) |
| [getAllItemsPerLocations](get-all-items-per-locations.md) | [androidJvm]<br>abstract fun [getAllItemsPerLocations](get-all-items-per-locations.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemPerLocationRel](../-item-per-location-rel/index.md)&gt;&gt; |
| [getAllLocations](get-all-locations.md) | [androidJvm]<br>abstract fun [getAllLocations](get-all-locations.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocation](../-items-per-location/index.md)&gt;&gt; |
| [getLocation](get-location.md) | [androidJvm]<br>abstract fun [getLocation](get-location.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[ItemsPerLocation](../-items-per-location/index.md)&gt; |
| [getLocationItemsPerLocation](get-location-items-per-location.md) | [androidJvm]<br>abstract fun [getLocationItemsPerLocation](get-location-items-per-location.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemPerLocationRel](../-item-per-location-rel/index.md)&gt;&gt; |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(itemsPerLocation: [ItemsPerLocation](../-items-per-location/index.md))<br>abstract suspend fun [insert](insert.md)(itemsPerLocations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ItemsPerLocation](../-items-per-location/index.md)&gt;) |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(location: [ItemsPerLocation](../-items-per-location/index.md)) |
