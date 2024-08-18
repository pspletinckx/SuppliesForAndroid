//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.ui.home](../index.md)/[HomeViewModel](index.md)

# HomeViewModel

[androidJvm]\
class [HomeViewModel](index.md)(itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel to retrieve all items in the Room database.

## Constructors

| | |
|---|---|
| [HomeViewModel](-home-view-model.md) | [androidJvm]<br>constructor(itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [homeUiState](home-ui-state.md) | [androidJvm]<br>val [homeUiState](home-ui-state.md): StateFlow&lt;[HomeUiState](../-home-ui-state/index.md)&gt;<br>Holds home ui state. The list of items are retrieved from [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md) and mapped to [HomeUiState](../-home-ui-state/index.md) |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
