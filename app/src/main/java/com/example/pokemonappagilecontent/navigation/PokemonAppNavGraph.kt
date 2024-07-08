package com.example.pokemonappagilecontent.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemonappagilecontent.list.ListPokemons
import com.example.pokemonappagilecontent.detail.PokemonDetail
import com.example.pokemonappagilecontent.detail.PokemonDetailViewModel
import com.example.pokemonappagilecontent.list.ListPokemonsViewModel
import org.koin.androidx.compose.koinViewModel

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
            val viewModel: ListPokemonsViewModel = koinViewModel()

            ListPokemons(
                viewModel = viewModel,
                onItemClick = { name ->
                val route = PokemonAppDestinations.DETAILS.replaceAfter('/', name)
                navController.navigate(route)
            })
        }
        composable(PokemonAppDestinations.DETAILS) { entry ->
            val viewModel: PokemonDetailViewModel = koinViewModel()

            entry.arguments?.getString("name")?.let {
                PokemonDetail(
                    name = it,
                    viewModel = viewModel
                )
            } ?: navController.popBackStack()
        }
    }
}