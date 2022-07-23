package com.hometech.composedemo.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItems(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomBarItems(route = "home", title = "Home", icon = Icons.Default.Home)
    object Profile : BottomBarItems(route = "profile", title = "Profile", icon = Icons.Default.Person)
    object Settings : BottomBarItems(route = "settings", title = "Settings", icon = Icons.Default.Settings)
}
