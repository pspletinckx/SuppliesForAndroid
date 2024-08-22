package be.pieterpletinckx.supplystorage.ui.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import be.pieterpletinckx.supplystorage.data.Datasource
import be.pieterpletinckx.supplystorage.data.item.Item
import be.pieterpletinckx.supplystorage.ui.theme.InventoryTheme
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test
import java.text.NumberFormat

class SearchByNameScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun searchByName_inputGiven() {
        composeTestRule.setContent {
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
        composeTestRule.onNodeWithTag("Searchbar").performTextInput("G")
        composeTestRule.onNodeWithText("San Andreas").assertExists(
            "Categories are shown."
        )
    }

    @Test
    fun searchByName_noInputGiven() {
        composeTestRule.setContent {
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

        composeTestRule.onNodeWithTag("Searchbar").performTextInput("")
        composeTestRule.onNodeWithText("Drinks").assertExists(
            "Categies are not shown."
        )
    }
}