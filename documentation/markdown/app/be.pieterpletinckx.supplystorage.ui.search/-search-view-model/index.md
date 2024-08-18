//[app](../../../index.md)/[be.pieterpletinckx.supplystorage.ui.search](../index.md)/[SearchViewModel](index.md)

# SearchViewModel

[androidJvm]\
class [SearchViewModel](index.md)(itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

| | |
|---|---|
| [SearchViewModel](-search-view-model.md) | [androidJvm]<br>constructor(itemsRepository: [ItemsRepository](../../be.pieterpletinckx.supplystorage.data.item/-items-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [isSearching](is-searching.md) | [androidJvm]<br>val [isSearching](is-searching.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt; |
| [searchText](search-text.md) | [androidJvm]<br>val [searchText](search-text.md): StateFlow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [searchUiState](search-ui-state.md) | [androidJvm]<br>val [searchUiState](search-ui-state.md): StateFlow&lt;[SearchUiState](../-search-ui-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [onSearchTextChange](on-search-text-change.md) | [androidJvm]<br>fun [onSearchTextChange](on-search-text-change.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onToogleSearch](on-toogle-search.md) | [androidJvm]<br>fun [onToogleSearch](on-toogle-search.md)() |
