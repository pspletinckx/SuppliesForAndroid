//[app](../../index.md)/[be.pieterpletinckx.supplystorage.data.item](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Item](-item/index.md) | [androidJvm]<br>data class [Item](-item/index.md)(val itemId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val price: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val quantity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Item is a class representing the definition can have multiple of in your supply storage. Has a 1 to N relationship with a physical ItemPerLocation |
| [ItemDao](-item-dao/index.md) | [androidJvm]<br>interface [ItemDao](-item-dao/index.md)<br>Database access object to access the Inventory database |
| [ItemsRepository](-items-repository/index.md) | [androidJvm]<br>interface [ItemsRepository](-items-repository/index.md)<br>Repository that provides insert, update, delete, and retrieve of [Item](-item/index.md) from a given data source. |
| [OfflineItemsRepository](-offline-items-repository/index.md) | [androidJvm]<br>class [OfflineItemsRepository](-offline-items-repository/index.md)(itemDao: [ItemDao](-item-dao/index.md)) : [ItemsRepository](-items-repository/index.md)<br>Concrete |
