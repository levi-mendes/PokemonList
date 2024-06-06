package com.example.pokemonappagilecontent.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokemonappagilecontent.components.LoadingDialog
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListPokemons(
    viewModel: ListPokemonsViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    ListPokemons(
        state = state,
        onNavigateToDetails = onItemClick
    )
}

@Composable
fun ListPokemons(
    modifier: Modifier = Modifier,
    state: ListPokemonsUiState = ListPokemonsUiState(),
    onNavigateToDetails: (String) -> Unit = {}
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
                        ItemPokemonList(
                            modifier = Modifier.clickable {
                                onNavigateToDetails(pokemon.name)
                            },
                            onItemClicked = onNavigateToDetails,
                            pokemon = pokemon
                        )
                    }
                )
            }
        }
    }
}