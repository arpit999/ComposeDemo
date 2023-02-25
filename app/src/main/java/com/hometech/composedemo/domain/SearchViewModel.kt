package com.hometech.composedemo.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hometech.composedemo.model.allProducts
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

@OptIn(FlowPreview::class)
class SearchViewModel : ViewModel() {

    // Textfield state when searching for products
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    // Show progress of the API request
    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    /**
     * Here we are displaying product list when textField is empty.
     * .combine() operator combine result of searchText and _products
     * .stateIn() operator convert that flow to state flow. So we can cache that last result in flow.
     * SharingStarted.WhileSubscribed(5000) : It will execute this flow for 5 Second when user move from that screen. Provide instant result when user come back.
     *.debounce(400) operator will wait for 0.4 sec and then execute request. If there is request on progress then it will cancel that request immediately and execute new one
     */
    private val _products = MutableStateFlow(allProducts)
    val products = searchText
        .debounce(400)
        .onEach { _isSearching.update { true } }
        .combine(_products) { searchText, products ->
            if (searchText.isEmpty()) {
                allProducts
            } else {
                // Mimic the api call to get product list
                delay(3000)
                products.filter {
                    it.doesMatchQuery(searchText)
                }
            }
        }
        .onEach { _isSearching.update { false } }
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