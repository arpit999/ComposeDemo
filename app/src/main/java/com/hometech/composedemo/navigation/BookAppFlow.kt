package com.hometech.composedemo.navigation

enum class BookAppFlow {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): BookAppFlow = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}