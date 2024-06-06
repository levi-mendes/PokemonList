package com.example.pokemonappagilecontent.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemonappagilecontent.list.ListPokemons
import com.example.pokemonappagilecontent.detail.PokemonDetail

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
            ListPokemons(onItemClick = { name ->
                navController.navigate("${PokemonAppDestinations.DETAILS}/$name")
            })
        }
        composable("${PokemonAppDestinations.DETAILS}/{name}") {
            PokemonDetail()
        }
    }
}