package be.pieterpletinckx.supplystorage.ui.location

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.data.Datasource
import be.pieterpletinckx.supplystorage.data.ItemsPerLocation
import be.pieterpletinckx.supplystorage.data.Location
import be.pieterpletinckx.supplystorage.ui.DynamicSelectTextField
import be.pieterpletinckx.supplystorage.ui.item.ItemDetails
import be.pieterpletinckx.supplystorage.ui.item.ItemUiState
import be.pieterpletinckx.supplystorage.ui.theme.InventoryTheme

@Composable
fun LocationsEntryList(
    modifier: Modifier = Modifier,
    locations: List<Location>,
    onValueChange: (ItemsPerLocation) -> Unit = {},
    createOnStart: Boolean = false
) {
    var createStorage by remember { mutableStateOf(createOnStart) }
    var addRow by remember { mutableStateOf(1) }
    Column() {
        for (i in 1..addRow) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DynamicSelectTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(3f)
                        .padding(3.dp),
                    selectedValue = "",
                    options = locations.map { it.locationName },
                    label = stringResource(id = R.string.item_location),
                    onValueChangedEvent = { },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                        unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    )
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(stringResource(R.string.quantity_symbol)) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                        unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(3.dp),
                    singleLine = true
                )
            }
        }
        var buttonActive by remember { mutableStateOf(true) }
        if (createStorage) {
//            Text(text = "New Location Creation goes here")
            LocationCreation(
                locationDetails = LocationDetails(),
                isValid = { buttonActive = it}
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Button(
                onClick = { createStorage = !createStorage },
                shape = MaterialTheme.shapes.small,
                modifier = modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .padding(3.dp),
                enabled = buttonActive
            ) {
                Text(text = stringResource(R.string.location_create_new))
            }
            Button(
                onClick = { addRow++ },
                shape = MaterialTheme.shapes.small,
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(3.dp),
            ) {
                Text(text = stringResource(R.string.location_add_another_symbol))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LocationSelectScreenPreview() {
    InventoryTheme {
        LocationsEntryList(
            locations = listOf(
                Location(
                    locationName = "Fridge",
                    parentId = null,
                    image = ""
                ),
                Location(
                    locationName = "Fridge",
                    parentId = null,
                    image = ""
                ),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LocationAddScreen() {
    InventoryTheme {
        LocationsEntryList(
            locations = listOf(),
            createOnStart = true,
            onValueChange = {}
        )
    }
}