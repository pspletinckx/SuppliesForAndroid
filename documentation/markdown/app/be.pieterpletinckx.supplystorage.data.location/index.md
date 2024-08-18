//[app](../../index.md)/[be.pieterpletinckx.supplystorage.data.location](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Location](-location/index.md) | [androidJvm]<br>data class [Location](-location/index.md)(val locationId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val locationName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val parentId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, val image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Location is a physical storage space where you can store ItemPerLocation from Item Eg: This can be a full room, a cabinet, or a single shelve (hence the parent rel) Has an N to 1 relationship with the physical object ItemPerLocation |
| [LocationConcreteRepository](-location-concrete-repository/index.md) | [androidJvm]<br>class [LocationConcreteRepository](-location-concrete-repository/index.md)(locationDao: [LocationDao](-location-dao/index.md)) : [LocationRepository](-location-repository/index.md)<br>Concrete mapper between the DInjected Interface and the DAO Object for Location |
| [LocationDao](-location-dao/index.md) | [androidJvm]<br>interface [LocationDao](-location-dao/index.md)<br>Data access object for Location |
| [LocationRepository](-location-repository/index.md) | [androidJvm]<br>interface [LocationRepository](-location-repository/index.md)<br>Interface for Location to be used via DInjection |
