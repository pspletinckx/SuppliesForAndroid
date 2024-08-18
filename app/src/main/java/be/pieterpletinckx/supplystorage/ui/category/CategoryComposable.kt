package be.pieterpletinckx.supplystorage.ui.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.pieterpletinckx.supplystorage.R
import be.pieterpletinckx.supplystorage.data.Category
import be.pieterpletinckx.supplystorage.data.Datasource


@Composable
fun CategoryList(
        affirmationList: List<Category>,
        modifier: Modifier = Modifier,
        onClick: (String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        modifier = modifier) {
        items(affirmationList) { affirmation ->
            CategoryCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp),
                onClick = onClick
            )
        }
    }
}

@Composable
fun CategoryCard(
    affirmation: Category,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    ) {
    Card(modifier = modifier,
        onClick = { onClick(affirmation.name)}) {
        Column {
            Image(
                painter = painterResource(affirmation.image),
                contentDescription = affirmation.name,
                modifier = Modifier
//                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = affirmation.name,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
private fun CategoryCardPreview() {
    CategoryCard(Category("Drinks", R.drawable.cocacola), onClick = {})
}

@Preview
@Composable
private fun CategoryGrid() {
    CategoryList(affirmationList = Datasource().loadCategories(),
        onClick = {})
}