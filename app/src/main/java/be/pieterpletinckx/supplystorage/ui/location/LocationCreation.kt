package be.pieterpletinckx.supplystorage.ui.location

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.data.Location.Location
import be.pieterpletinckx.supplystorage.ui.theme.InventoryTheme

@Composable
fun LocationCreation(
    locationDetails: LocationDetails,
    availableLocations: List<Location>,
    modifier: Modifier = Modifier,
    onValueChange: (LocationDetails) -> Unit = {},
    isValid: (Boolean) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
    ) {
        OutlinedTextField(
            value = locationDetails.name,
            onValueChange = { onValueChange(locationDetails.copy(name = it)) },
            label = { Text(stringResource(R.string.location_name_req)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        LocationSelectTextField(
            availableLocations = availableLocations,
            onValueChange = { onValueChange(locationDetails.copy(parent = it.locationId))}
        )
        OutlinedTextField(
            value = locationDetails.image,
            onValueChange = { onValueChange(locationDetails.copy(image = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = { Text(stringResource(R.string.location_image_opt)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        if (enabled) {
            Text(
                text = stringResource(R.string.required_fields),
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemEntryScreenPreview() {
    InventoryTheme {
        LocationCreation(
            LocationDetails(0,"",null,""),
            availableLocations= listOf(),
            onValueChange = {},
            enabled = true)
    }
}