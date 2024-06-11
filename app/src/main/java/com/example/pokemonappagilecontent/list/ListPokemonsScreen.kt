package com.example.pokemonappagilecontent.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemonappagilecontent.components.LoadingDialog
import com.example.pokemonappagilecontent.ui.theme.PokemonAppAgileContentTheme
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

    state.error?.message?.let { errorMessage ->
        Text(
            text = errorMessage,
            color = Color.Red,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(16.dp)
        )
    }

    Column {
        modifier.padding(horizontal = 16.dp, vertical = 6.dp)

        if (state.searchHasFinished()) {
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

@Preview
@Composable
fun ListPokemonsPreview() {
    val viewModel: ListPokemonsViewModel = koinViewModel()
    val state by viewModel.uiState.collectAsState()

    PokemonAppAgileContentTheme {
        ListPokemons(
            modifier = Modifier,
            state = state,
            onNavigateToDetails = { },
            viewModel = viewModel
        )
    }
}