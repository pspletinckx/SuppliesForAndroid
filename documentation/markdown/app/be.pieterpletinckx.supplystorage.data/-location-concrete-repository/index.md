//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.data](../index.md)/[LocationConcreteRepository](index.md)

# LocationConcreteRepository

[androidJvm]\
class [LocationConcreteRepository](index.md)(locationDao: [LocationDao](../-location-dao/index.md)) : [LocationRepository](../-location-repository/index.md)

## Constructors

| | |
|---|---|
| [LocationConcreteRepository](-location-concrete-repository.md) | [androidJvm]<br>constructor(locationDao: [LocationDao](../-location-dao/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getAllItemsStream](get-all-items-stream.md) | [androidJvm]<br>open override fun [getAllItemsStream](get-all-items-stream.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Location](../-location/index.md)&gt;&gt; |
| [insertLocation](insert-location.md) | [androidJvm]<br>open suspend override fun [insertLocation](insert-location.md)(location: [Location](../-location/index.md)) |
