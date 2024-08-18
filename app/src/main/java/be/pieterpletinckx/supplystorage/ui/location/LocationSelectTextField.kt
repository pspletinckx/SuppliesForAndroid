package be.pieterpletinckx.supplystorage.ui.location

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.data.Location
import be.pieterpletinckx.supplystorage.ui.DynamicSelectTextField

@Composable
fun LocationSelectTextField (
    availableLocations: List<Location>,
    onValueChange: (Location) -> Unit = {},
    modifier: Modifier = Modifier
){
    var selectedLocation by remember { mutableStateOf("") }
    DynamicSelectTextField(
        modifier= modifier,
        selectedValue = selectedLocation,
        options = availableLocations.map { it.locationName },
        label = stringResource(id = R.string.item_location),
        onValueChangedEvent = { selected -> run {
                selectedLocation = selected
                availableLocations.find { it.locationName == selected }?.let(onValueChange)
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    )
}