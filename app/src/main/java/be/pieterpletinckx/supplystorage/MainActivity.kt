package be.pieterpletinckx.supplystorage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.pieterpletinckx.supplystorage.data.Datasource
import be.pieterpletinckx.supplystorage.model.ProductDefinition
import be.pieterpletinckx.supplystorage.ui.theme.SupplyStorageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SupplyStorageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductsApp()
                }
            }
        }
    }
}

@Composable
fun ProductsApp() {
    ProductList(
        ProductList = Datasource().loadProducts(),
    )
}

@Composable
fun ProductList(ProductList: List<ProductDefinition>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(ProductList) { Product ->
            ProductCard(
                Product = Product,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ProductCard(Product: ProductDefinition, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
//            Image(
//                painter = painterResource(Product.image),
//                contentDescription = stringResource(Product.alias),
//                modifier = Modifier
////                    .fillMaxWidth()
//                    .height(194.dp),
//                contentScale = ContentScale.Crop
//            )
            Text(
                text = LocalContext.current.getString(Product.name),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    ProductCard(ProductDefinition(R.string.product_cola, R.drawable.cocacola))
}