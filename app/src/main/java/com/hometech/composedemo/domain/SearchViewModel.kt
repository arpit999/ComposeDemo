package com.hometech.composedemo.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hometech.composedemo.model.allProducts
import kotlinx.coroutines.flow.*

class SearchViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _products = MutableStateFlow(allProducts)
    val products = searchText
        .combine(_products) { searchText, products ->
            if (searchText.isEmpty()) {
                allProducts
            } else {
                products.filter {
                    it.doesMatchQuery(searchText)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _products.value
        )

    fun onSearchText(text: String) {
        _searchText.value = text
    }

}