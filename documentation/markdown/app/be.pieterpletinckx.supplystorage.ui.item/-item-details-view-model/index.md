//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.ui.item](../index.md)/[ItemDetailsViewModel](index.md)

# ItemDetailsViewModel

[androidJvm]\
class [ItemDetailsViewModel](index.md)(savedStateHandle: [SavedStateHandle](https://developer.android.com/reference/kotlin/androidx/lifecycle/SavedStateHandle.html), itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel to retrieve, update and delete an item from the [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)'s data source.

## Constructors

| | |
|---|---|
| [ItemDetailsViewModel](-item-details-view-model.md) | [androidJvm]<br>constructor(savedStateHandle: [SavedStateHandle](https://developer.android.com/reference/kotlin/androidx/lifecycle/SavedStateHandle.html), itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [uiState](ui-state.md) | [androidJvm]<br>val [uiState](ui-state.md): StateFlow&lt;[ItemDetailsUiState](../-item-details-ui-state/index.md)&gt;<br>Holds the item details ui state. The data is retrieved from [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md) and mapped to the UI state. |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [deleteItem](delete-item.md) | [androidJvm]<br>suspend fun [deleteItem](delete-item.md)()<br>Deletes the item from the [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)'s data source. |
| [reduceQuantityByOne](reduce-quantity-by-one.md) | [androidJvm]<br>fun [reduceQuantityByOne](reduce-quantity-by-one.md)()<br>Reduces the item quantity by one and update the [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)'s data source. |
