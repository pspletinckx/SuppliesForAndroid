/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package be.pieterpletinckx.supplystorage.ui.location

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import be.pieterpletinckx.supplystorage.InventoryTopAppBar
import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.data.Location.Location
import be.pieterpletinckx.supplystorage.ui.AppViewModelProvider
import be.pieterpletinckx.supplystorage.ui.navigation.NavigationDestination
import be.pieterpletinckx.supplystorage.ui.theme.InventoryTheme
import kotlinx.coroutines.launch

object LocationEntryDestination : NavigationDestination {
    override val route = "location_entry"
    override val titleRes = R.string.location_entry_title
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationEntryScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    viewModel: LocationEntryViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            InventoryTopAppBar(
                title = stringResource(LocationEntryDestination.titleRes),
                canNavigateBack = canNavigateBack,
                navigateUp = onNavigateUp
            )
        }
    ) { innerPadding ->
        val locations by viewModel.availableLocations.collectAsState()
        ItemEntryBody(
            locationUiState = viewModel.locationUiState,
            availableLocations = locations,
            onItemValueChange = viewModel::updateUiState,
            onSaveClick = {
                // Note: If the user rotates the screen very fast, the operation may get cancelled
                // and the item may not be saved in the Database. This is because when config
                // change occurs, the Activity will be recreated and the rememberCoroutineScope will
                // be cancelled - since the scope is bound to composition.
                coroutineScope.launch {
                    viewModel.saveItem()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                )
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}

@Composable
fun ItemEntryBody(
    locationUiState: LocationUiState,
    availableLocations:List<Location>,
    onItemValueChange: (LocationDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large))
    ) {
        LocationCreation(
            locationDetails = locationUiState.locationDetails,
            availableLocations = availableLocations,
            onValueChange = onItemValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            enabled = locationUiState.isEntryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.save_action))
        }
    }
}

//@Composable
//fun ItemInputForm(
//    itemDetails: ItemDetails,
//    modifier: Modifier = Modifier,
//    onValueChange: (ItemDetails) -> Unit = {},
//    enabled: Boolean = true
//) {
//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
//    ) {
//        OutlinedTextField(
//            value = itemDetails.name,
//            onValueChange = { onValueChange(itemDetails.copy(name = it)) },
//            label = { Text(stringResource(R.string.item_name_req)) },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            ),
//            modifier = Modifier.fillMaxWidth(),
//            enabled = enabled,
//            singleLine = true
//        )
//
//        DynamicSelectTextField(
//            selectedValue = itemDetails.category,
//            options = Datasource().loadCategories().map { stringResource(it.name) },
//            label = stringResource(id = R.string.item_category_req),
//            onValueChangedEvent = { onValueChange(itemDetails.copy(category = it)) },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            )
//        )
//        OutlinedTextField(
//            value = itemDetails.price,
//            onValueChange = { onValueChange(itemDetails.copy(price = it)) },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
//            label = { Text(stringResource(R.string.item_price_req)) },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            ),
//            leadingIcon = { Text(Currency.getInstance(Locale.getDefault()).symbol) },
//            modifier = Modifier.fillMaxWidth(),
//            enabled = enabled,
//            singleLine = true
//        )
////        OutlinedTextField(
////            value = itemDetails.quantity,
////            onValueChange = { onValueChange(itemDetails.copy(quantity = it)) },
////            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
////            label = { Text(stringResource(R.string.quantity_req)) },
////            colors = OutlinedTextFieldDefaults.colors(
////                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
////                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
////                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
////            ),
////            modifier = Modifier.fillMaxWidth(),
////            enabled = enabled,
////            singleLine = true
////        )
//        DynamicSelectTextField(
//            selectedValue = itemDetails.location,
//            options = Datasource().loadCategories().map { stringResource(it.name) },
//            label = stringResource(id = R.string.item_category_req),
//            onValueChangedEvent = { onValueChange(itemDetails.copy(category = it)) },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            )
//        )
//        if (enabled) {
//            Text(
//                text = stringResource(R.string.required_fields),
//                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
//            )
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
private fun ItemEntryScreenPreview() {
    InventoryTheme {
        ItemEntryBody(
            locationUiState = LocationUiState(
                LocationDetails(name = "Fridge", parent = null, image = "Image Todo")),
            availableLocations = listOf(),
            onItemValueChange = {},
            onSaveClick = {})
    }
}
