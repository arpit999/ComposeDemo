package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                val products by viewModel.products.collectAsState()
                val isSearching by viewModel.isSearching.collectAsState()

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
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(products) { product ->
                    Text(
                        text = product.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeDemoTheme {
            SearchView(searchText = "tooth", products = allProducts, isSearching = false, onSearchText = { })
        }
    }

}

