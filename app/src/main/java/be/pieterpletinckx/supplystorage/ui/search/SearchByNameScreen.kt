package be.pieterpletinckx.supplystorage.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.data.Item
import be.pieterpletinckx.supplystorage.ui.AppViewModelProvider
import be.pieterpletinckx.supplystorage.ui.home.HomeBody
import be.pieterpletinckx.supplystorage.ui.home.HomeViewModel
import be.pieterpletinckx.supplystorage.ui.navigation.NavigationDestination
import be.pieterpletinckx.supplystorage.ui.theme.InventoryTheme

/**
* This triggered by typing the name of a product in a single input field
*/

object SearchByName : NavigationDestination {
    override val route = "search"
    override val titleRes = R.string.app_name
}
@Composable
fun SearchByNameScreen(
    navigateToItemEntry: () -> Unit,
    navigateToItemUpdate: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val searchUiState by viewModel.searchUiState.collectAsState()
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    Scaffold {
        SearchByName(
            searchUiState.itemList,
            searchText,
            onItemClick = navigateToItemUpdate,
            onItemSearch = viewModel::onSearchTextChange)
    }
}

@Composable
fun SearchByName(
    itemList: List<Item>,
    searchTerm: String,
    onItemClick: (Int) -> Unit,
    onItemSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    var term by remember { mutableStateOf("Hello") }
    Column (
        modifier = Modifier
            .padding(20.dp)
            .padding(top = 40.dp)
//                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        OutlinedTextField(
            value = searchTerm,
            onValueChange = onItemSearch,
            label = {"Type to search"},
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        HomeBody(itemList, onItemClick = onItemClick)
    }
}

@Preview(showBackground = true)
@Composable
fun nameInputSearch(
) {
    InventoryTheme {
        SearchByName(
            listOf(
                Item(1, "Game", 100.0, 20),
                Item(2, "Pen", 200.0, 30),
                Item(3, "TV", 300.0, 50)
            ),
            "",
            onItemClick = {},
            onItemSearch = {}
        )
    }
}