package com.example.pokemonappagilecontent.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
        onNavigateToDetails = onItemClick,
        viewModel = viewModel
    )
}

@Composable
fun ListPokemons(
    modifier: Modifier = Modifier,
    state: ListPokemonsUiState = ListPokemonsUiState(),
    onNavigateToDetails: (String) -> Unit = {},
    viewModel: ListPokemonsViewModel
) {

    if (state.loading) {
        LoadingDialog {}
    }

    Column {
        modifier.padding(horizontal = 16.dp, vertical = 6.dp)

        if (!state.loading && state.isNewResultSearch) {
            state.pokemons?.let { pokemons ->
                LazyColumn {
                    itemsIndexed(items = pokemons) { index, item ->
                        ItemPokemonList(
                            modifier = Modifier
                                .clickable {
                                    onNavigateToDetails(item.name)
                                },
                            onItemClicked = onNavigateToDetails,
                            pokemon = item
                        )

                        if (index == state.pokemons.lastIndex) {
                            viewModel.loadNextPokemonPage()
                        }
                    }
                }
            }
        }
    }
}