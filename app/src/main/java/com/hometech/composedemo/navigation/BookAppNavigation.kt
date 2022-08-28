package com.hometech.composedemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hometech.composedemo.screens.details.DetailsScreen
import com.hometech.composedemo.screens.home.HomeScreen

@Composable
fun BookAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BookAppFlow.HomeScreen.name) {
        composable(route = BookAppFlow.HomeScreen.name) {
            //here we can pass where this should lead us. It is basically Screen composable
            HomeScreen(navController = navController)
        }
        composable(
            route = BookAppFlow.DetailsScreen.name + "/{book}",
            arguments = listOf(navArgument("book") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("book"))
        }
    }
}