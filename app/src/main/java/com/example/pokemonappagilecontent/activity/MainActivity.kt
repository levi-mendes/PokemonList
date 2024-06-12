package com.example.pokemonappagilecontent.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokemonappagilecontent.R
import com.example.pokemonappagilecontent.navigation.PokemonAppDestinations
import com.example.pokemonappagilecontent.navigation.PokemonAppNavGraph
import com.example.pokemonappagilecontent.ui.theme.PokemonAppAgileContentTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            PokemonAppAgileContentTheme {
                Scaffold (
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { TitleScreen(currentRoute) },
                            navigationIcon = { currentRoute?.let { SetDrawerIcon(currentRoute, navController) }},
                        )
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        PokemonAppNavGraph(navController = navController)
                    }
                }
            }
        }
    }

    @Composable
    fun TitleScreen(route: String?) {
        val title = when(route) {
            PokemonAppDestinations.LIST -> stringResource(id = R.string.topbar_title_pokemons)
            PokemonAppDestinations.DETAILS -> stringResource(id = R.string.topbar_title_details)
            else -> { "" }
        }
        Text(text = title)
    }

    @Composable
    fun NavigatonIconBack(navController: NavHostController) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        }
    }

    @Composable
    fun SetDrawerIcon(currentRoute: String, navController: NavHostController) {
         if (currentRoute == PokemonAppDestinations.DETAILS) {
             NavigatonIconBack(navController)
         }
    }
}