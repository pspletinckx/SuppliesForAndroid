//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.ui.item](../index.md)/[ItemEditViewModel](index.md)

# ItemEditViewModel

[androidJvm]\
class [ItemEditViewModel](index.md)(savedStateHandle: [SavedStateHandle](https://developer.android.com/reference/kotlin/androidx/lifecycle/SavedStateHandle.html), itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel to retrieve and update an item from the [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)'s data source.

## Constructors

| | |
|---|---|
| [ItemEditViewModel](-item-edit-view-model.md) | [androidJvm]<br>constructor(savedStateHandle: [SavedStateHandle](https://developer.android.com/reference/kotlin/androidx/lifecycle/SavedStateHandle.html), itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [itemUiState](item-ui-state.md) | [androidJvm]<br>var [itemUiState](item-ui-state.md): [ItemUiState](../-item-ui-state/index.md)<br>Holds current item ui state |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../be.pieterpletinckx.supplystorage.ui.search/-search-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [updateItem](update-item.md) | [androidJvm]<br>suspend fun [updateItem](update-item.md)()<br>Update the item in the [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)'s data source |
| [updateUiState](update-ui-state.md) | [androidJvm]<br>fun [updateUiState](update-ui-state.md)(itemDetails: [ItemDetails](../-item-details/index.md))<br>Updates the [itemUiState](item-ui-state.md) with the value provided in the argument. This method also triggers a validation for input values. |
