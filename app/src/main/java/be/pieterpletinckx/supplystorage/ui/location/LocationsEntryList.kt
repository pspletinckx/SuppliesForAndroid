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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.data.location.Location
import be.pieterpletinckx.supplystorage.ui.theme.InventoryTheme

/**
 * Composable that deals with adding the relationship between Item and Location
 */
@Composable
fun LocationsEntryList(
    modifier: Modifier = Modifier,
    availableLocations: List<Location>,
    onValueChange: (List<ItemsPerLocationDetails>) -> Unit = {},
    createOnStart: Boolean = false
) {
    var createStorage by remember { mutableStateOf(createOnStart) }

    val rows = remember { mutableStateListOf<ItemsPerLocationDetails>(ItemsPerLocationDetails())}
    Column() {
        for (i in 0..<rows.size) {
            var row = rows[i]
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                LocationSelectTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(3f)
                        .padding(3.dp),
                    availableLocations = availableLocations,
                    onValueChange = {
                        rows[i] = row.copy(locationFkId = it.locationId)
                        onValueChange(rows.toList())
                    }
                )
                OutlinedTextField(
                    value = rows[i].quantity.toString(),
                    onValueChange = {
                        rows[i] = row.copy(quantity = it)
                        onValueChange(rows.toList())
                    },
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
                availableLocations= availableLocations,
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
                enabled = false
            ) {
                Text(text = stringResource(R.string.location_create_new))
            }
            Button(
                onClick = { rows.add(ItemsPerLocationDetails()) },
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
            availableLocations = listOf(
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
            availableLocations = listOf(),
            createOnStart = true,
            onValueChange = {}
        )
    }
}