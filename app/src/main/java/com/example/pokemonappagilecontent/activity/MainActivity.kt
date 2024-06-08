package com.example.pokemonappagilecontent.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.pokemonappagilecontent.navigation.PokemonAppNavGraph
import com.example.pokemonappagilecontent.ui.theme.PokemonAppAgileContentTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            PokemonAppAgileContentTheme {
                Scaffold (
                    topBar = {
                        TopAppBar(title = { Text(text = "Pokemons") })
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
}