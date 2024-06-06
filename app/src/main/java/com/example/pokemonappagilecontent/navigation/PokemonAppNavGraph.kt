package com.example.pokemonappagilecontent.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemonappagilecontent.ListPokemons

@Composable
fun PokemonAppNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = PokemonAppDestinations.LIST
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(PokemonAppDestinations.LIST) {
            ListPokemons()
        }
        composable(PokemonAppDestinations.DETAILS) {
//            DetailsScreen()
        }
    }
}