package com.hometech.composedemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hometech.composedemo.domain.SearchViewModel
import com.hometech.composedemo.model.Product
import com.hometech.composedemo.model.allProducts
import com.hometech.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {

                val viewModel = viewModel<SearchViewModel>()
                val searchText by viewModel.searchText.collectAsState()
                val isSearching by viewModel.isSearching.collectAsState()
                val products by viewModel.products.collectAsState()

                Surface(color = MaterialTheme.colors.background) {
                    SearchView(searchText, products, isSearching, viewModel::onSearchText)
                }
            }
        }
    }

    @Composable
    fun SearchView(searchText: String, products: List<Product>, isSearching: Boolean, onSearchText: (String) -> Unit) {

        Column(modifier = Modifier.fillMaxWidth()) {

            OutlinedTextField(
                value = searchText,
                onValueChange = onSearchText,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Search"
                    )
                })
            if (isSearching) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    items(products) { product ->
                        ProductItem(product = product)
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun ProductItem(product: Product) {
        val context = LocalContext.current

        Card(modifier = Modifier.clickable {
            Toast.makeText(context, product.toString(), Toast.LENGTH_SHORT).show()
            Log.d("Product", "ProductItem: $product")
        }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(
                    text = "Description: ${product.description}",
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = "Category: ${product.type}",
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = "$${product.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewProductItem() {
        ProductItem(product = Product(1, "Laptop", "Thin and light laptop with long battery life", "Electronics", 1200))
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeDemoTheme {
            SearchView(searchText = "", products = allProducts, isSearching = true) { }
        }
    }

}

