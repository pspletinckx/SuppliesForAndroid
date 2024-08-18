//[app](../../index.md)/[be.pieterpletinckx.supplystorage.ui.home](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [HomeDestination](-home-destination/index.md) | [androidJvm]<br>object [HomeDestination](-home-destination/index.md) : [NavigationDestination](../be.pieterpletinckx.supplystorage.ui.navigation/-navigation-destination/index.md) |
| [HomeUiState](-home-ui-state/index.md) | [androidJvm]<br>data class [HomeUiState](-home-ui-state/index.md)(val itemList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Item](../be.pieterpletinckx.supplystorage.data.item/-item/index.md)&gt; = listOf())<br>Ui State for HomeScreen |
| [HomeViewModel](-home-view-model/index.md) | [androidJvm]<br>class [HomeViewModel](-home-view-model/index.md)(itemsRepository: [ItemsRepository](../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel to retrieve all items in the Room database. |

## Functions

| Name | Summary |
|---|---|
| [HomeBody](-home-body.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HomeBody](-home-body.md)(itemList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Item](../be.pieterpletinckx.supplystorage.data.item/-item/index.md)&gt;, onItemClick: ([Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = PaddingValues(0.dp)) |
| [HomeBodyEmptyListPreview](-home-body-empty-list-preview.md) | [androidJvm]<br>@[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)(showBackground = true)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HomeBodyEmptyListPreview](-home-body-empty-list-preview.md)() |
| [HomeBodyPreview](-home-body-preview.md) | [androidJvm]<br>@[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)(showBackground = true)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HomeBodyPreview](-home-body-preview.md)() |
| [HomeScreen](-home-screen.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [~~HomeScreen~~](-home-screen.md)(navigateToItemEntry: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), navigateToItemUpdate: ([Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, viewModel: [HomeViewModel](-home-view-model/index.md) = viewModel(factory = AppViewModelProvider.Factory))<br>Entry route for Home screen, currently replaced by SearchByNameScreen |
| [InventoryItemPreview](-inventory-item-preview.md) | [androidJvm]<br>@[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)(showBackground = true)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [InventoryItemPreview](-inventory-item-preview.md)() |
