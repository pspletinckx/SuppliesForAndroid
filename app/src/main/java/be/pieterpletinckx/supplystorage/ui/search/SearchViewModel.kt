package be.pieterpletinckx.supplystorage.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.pieterpletinckx.supplystorage.data.Item
import be.pieterpletinckx.supplystorage.data.ItemsRepository
import be.pieterpletinckx.supplystorage.ui.home.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SearchViewModel (itemsRepository: ItemsRepository) : ViewModel() {

    /**
     * Holds home ui state. The list of items are retrieved from [ItemsRepository] and mapped to
     * [HomeUiState]
     */

    //first state whether the search is happening or not
    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    //second state the text typed by the user
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    val searchUiState: StateFlow<SearchUiState> = itemsRepository.getAllItemsStream()
        .combine(searchText) {
            items, search -> items.filter {
                item -> item.name.uppercase().contains(search.uppercase())
            }
        }
        .map { SearchUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = SearchUiState()
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun onToogleSearch() {
        _isSearching.value = !_isSearching.value
        if (!_isSearching.value) {
            onSearchTextChange("")
        }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class SearchUiState(
    val itemList: List<Item> = listOf(),
//    var searchTerm: String = ""
)