package com.hometech.composedemo.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hometech.composedemo.model.allProducts
import kotlinx.coroutines.flow.*

class SearchViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    /**
     * Here we are displaying product list when textField is empty.
     * .combine() operator combine result of searchText and _products
     * .stateIn() operator convert that flow to state flow. So we can cache that last result in flow.
     * SharingStarted.WhileSubscribed(5000) : It will execute this flow for 5 Second when user move from that screen. Provide instant result when user come back.
     *
     */
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

    /**
     * @param text Provide text and that type in field and update SearchText state
     */
    fun onSearchText(text: String) {
        _searchText.value = text
    }

}