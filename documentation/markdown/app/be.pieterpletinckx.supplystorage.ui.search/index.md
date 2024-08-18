//[app](../../index.md)/[be.pieterpletinckx.supplystorage.ui.search](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [SearchByName](-search-by-name/index.md) | [androidJvm]<br>object [SearchByName](-search-by-name/index.md) : [NavigationDestination](../be.pieterpletinckx.supplystorage.ui.navigation/-navigation-destination/index.md)<br>A screen that allows for both quick categorical nav  and search triggered by typing the name of a product in a single input field |
| [SearchUiState](-search-ui-state/index.md) | [androidJvm]<br>data class [SearchUiState](-search-ui-state/index.md)(val itemList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Item](../be.pieterpletinckx.supplystorage.data.item/-item/index.md)&gt; = listOf()) |
| [SearchViewModel](-search-view-model/index.md) | [androidJvm]<br>class [SearchViewModel](-search-view-model/index.md)(itemsRepository: [ItemsRepository](../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [nameInputSearch](name-input-search.md) | [androidJvm]<br>@[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)(showBackground = true)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [nameInputSearch](name-input-search.md)() |
| [nameNoInputSearch](name-no-input-search.md) | [androidJvm]<br>@[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)(showBackground = true)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [nameNoInputSearch](name-no-input-search.md)() |
| [SearchByName](-search-by-name.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [SearchByName](-search-by-name.md)(itemList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Item](../be.pieterpletinckx.supplystorage.data.item/-item/index.md)&gt;, searchTerm: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onItemClick: ([Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onItemSearch: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = PaddingValues(0.dp))<br>Contains the main searchbar + results + category construction |
| [SearchByNameScreen](-search-by-name-screen.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [SearchByNameScreen](-search-by-name-screen.md)(navigateToItemEntry: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), navigateToItemUpdate: ([Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, viewModel: [SearchViewModel](-search-view-model/index.md) = viewModel(factory = AppViewModelProvider.Factory)) |
