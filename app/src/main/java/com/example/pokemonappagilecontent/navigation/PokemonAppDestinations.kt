package com.example.pokemonappagilecontent.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object PokemonAppDestinations {
    const val LIST = "list"
    const val DETAILS = "details"
}

class PokemonAppNavigationActions(navController: NavHostController) {
    val navigateToList: () -> Unit = {
        navController.navigate(PokemonAppDestinations.LIST) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
    val navigateToDetails: () -> Unit = {
        navController.navigate(PokemonAppDestinations.DETAILS) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}