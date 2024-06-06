package com.example.pokemonappagilecontent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListPokemons(
    viewModel: ListPokemonsViewModel = koinViewModel(),
) {
    val state by viewModel.uiState.collectAsState()

    ListPokemons(state = state)
}

@Composable
fun ListPokemons(
    modifier: Modifier = Modifier,
    state: ListAllPokemonsUiState = ListAllPokemonsUiState(),
) {

    if (state.loading) {
        LoadingDialog {}
    }

    Column {
        modifier.padding(horizontal = 16.dp, vertical = 6.dp)

        state.pokemons?.let { pokemons ->
            LazyColumn {
                items(
                    items = pokemons,
                    itemContent = { pokemon ->
                        ItemPokemonList(pokemon = pokemon)
                    }
                )
            }
        }
    }
}