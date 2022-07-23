package com.hometech.composedemo.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hometech.composedemo.ui.theme.ComposeDemoTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    ComposeDemoTheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomBar(navHostController = navController)
            }
        ) {
            BottomNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    val screens = listOf(
        BottomBarItems.Home,
        BottomBarItems.Profile,
        BottomBarItems.Settings
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach { screen ->
            if (currentDestination != null) {
                AddItem(screen = screen, currentDestination = currentDestination, navHostController = navHostController)
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarItems,
    currentDestination: NavDestination,
    navHostController: NavHostController
) {
    BottomNavigationItem(
        selected = currentDestination.hierarchy.any {
            it.route == currentDestination.route
        },
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "You are on ${screen.title}")
        },
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
    )

}