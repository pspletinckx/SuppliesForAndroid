package be.pieterpletinckx.supplystorage.ui.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.pieterpletinckx.supplystorage.InventoryTopAppBar
import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.data.Datasource
import be.pieterpletinckx.supplystorage.data.category.Category
import be.pieterpletinckx.supplystorage.data.item.Item
import be.pieterpletinckx.supplystorage.ui.AppViewModelProvider
import be.pieterpletinckx.supplystorage.ui.category.CategoryList
import be.pieterpletinckx.supplystorage.ui.home.HomeBody
import be.pieterpletinckx.supplystorage.ui.navigation.NavigationDestination
import be.pieterpletinckx.supplystorage.ui.theme.InventoryTheme

/**
 * A screen that allows for both quick categorical nav  and search
 * triggered by typing the name of a product in a single input field
*/

object SearchByName : NavigationDestination {
    override val route = "search"
    override val titleRes = R.string.app_name
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchByNameScreen(
    navigateToItemEntry: () -> Unit,
    navigateToItemUpdate: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val searchUiState by viewModel.searchUiState.collectAsState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val searchText by viewModel.searchText.collectAsState()
    val categories by viewModel.categoryUiState.collectAsState()

    Scaffold (
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            InventoryTopAppBar(
                title = "",
                canNavigateBack = false,
                scrollBehavior = scrollBehavior,
                modifier = modifier.height(0.dp)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(
                        end = WindowInsets.safeDrawing.asPaddingValues()
                            .calculateEndPadding(LocalLayoutDirection.current)
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.item_entry_title)
                )
            }
        },
    ){ innerPadding ->
        SearchByName(
            searchUiState.itemList,
            searchText,
            categories = categories,
            onItemClick = navigateToItemUpdate,
            onItemSearch = viewModel::onSearchTextChange,
            modifier = modifier.fillMaxSize(),
            contentPadding = innerPadding)
    }
}

/**
 * Contains the main searchbar + results + category construction
 */
@Composable
fun SearchByName(
    itemList: List<Item>,
    searchTerm: String,
    onItemClick: (Int) -> Unit,
    onItemSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    categories: List<Category>
){
    Column (
        modifier = modifier
            .padding(20.dp)
            .padding(top = 40.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
//                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        OutlinedTextField(
            value = searchTerm,
            onValueChange = onItemSearch,
            label = { stringResource(R.string.type_to_search) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth().testTag("Searchbar"),
            enabled = true,
            singleLine = true,
            trailingIcon = {
                Icon(Icons.Default.Clear,
                    contentDescription = "clear text",
                    modifier = Modifier.clickable(
                        onClick = {onItemSearch("")}
                    )
                )
            }
        )
        AnimatedVisibility(visible = searchTerm.isNotBlank()){
            HomeBody(itemList, onItemClick = onItemClick)
        }
        CategoryList(affirmationList = categories, onClick = onItemSearch)

//        if(searchTerm.isNotBlank()) {
//            HomeBody(itemList, onItemClick = onItemClick)
//        } else {
//            CategoryList(affirmationList = categories,
//                onClick = onItemSearch)
//        }
    }
}
@Preview(showBackground = true)
@Composable
fun nameNoInputSearch(
) {
    InventoryTheme {
        SearchByName(
            listOf(
                Item(1, "San Andreas", 100.0, 20, "Game"),
                Item(2, "Pen", 200.0, 30, "Desk"),
                Item(3, "TV", 300.0, 50, "Electronics")
            ),
            "",
            onItemClick = {},
            onItemSearch = {},
            categories = Datasource().loadCategories()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun nameInputSearch(
) {
    InventoryTheme {
        SearchByName(
            listOf(
                Item(1, "San Andreas", 100.0, 20, "Game"),
                Item(2, "Pen", 200.0, 30, "Desk"),
                Item(3, "TV", 300.0, 50, "Electronics")
            ),
            "G",
            onItemClick = {},
            onItemSearch = {},
            categories = Datasource().loadCategories()
        )
    }
}