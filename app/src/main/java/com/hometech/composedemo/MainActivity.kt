package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hometech.composedemo.domain.SearchViewModel
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


                }
            }
        }
    }

    @Composable
    fun SearchField() {

        Column {

        }
    }

    //    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeDemoTheme {

        }
    }

}

