//[app](../../index.md)/[be.pieterpletinckx.supplystorage.data.itemPerLocation](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ItemPerLocationRel](-item-per-location-rel/index.md) | [androidJvm]<br>data class [ItemPerLocationRel](-item-per-location-rel/index.md)(val itemsPerLocation: [ItemsPerLocation](-items-per-location/index.md), val location: [Location](../be.pieterpletinckx.supplystorage.data.location/-location/index.md), val item: [Item](../be.pieterpletinckx.supplystorage.data.item/-item/index.md))<br>RoomDB Relational class that pulls in both Location and Item objects, Used in multiple DOA depending on QUer |
| [ItemsPerLocation](-items-per-location/index.md) | [androidJvm]<br>data class [ItemsPerLocation](-items-per-location/index.md)(val itemLocationCrossRefId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val locationFkId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val itemId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val quantity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>ItemPerLocation is a physical object that is an Item stored in a Location Has a 1 to N relationship with both Item and Location, whilst adding the field quanity |
| [ItemsPerLocationConcreteRepository](-items-per-location-concrete-repository/index.md) | [androidJvm]<br>class [ItemsPerLocationConcreteRepository](-items-per-location-concrete-repository/index.md)(itemsPerLocationDao: [ItemsPerLocationDao](-items-per-location-dao/index.md)) : [ItemsPerLocationRepository](-items-per-location-repository/index.md)<br>Concrete mapper for ItemsPerLocationRepo |
| [ItemsPerLocationDao](-items-per-location-dao/index.md) | [androidJvm]<br>interface [ItemsPerLocationDao](-items-per-location-dao/index.md)<br>Data access object of for ItemsPerLocation |
| [ItemsPerLocationRepository](-items-per-location-repository/index.md) | [androidJvm]<br>interface [ItemsPerLocationRepository](-items-per-location-repository/index.md)<br>Interface for ItemsPerLocation as DInjected in the UI |
