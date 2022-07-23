package com.hometech.composedemo.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hometech.composedemo.ui.screens.HomeScreen
import com.hometech.composedemo.ui.screens.ProfileScreen
import com.hometech.composedemo.ui.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = BottomBarItems.Home.route) {
        composable(route = BottomBarItems.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarItems.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarItems.Settings.route) {
            SettingsScreen()
        }
    }
}