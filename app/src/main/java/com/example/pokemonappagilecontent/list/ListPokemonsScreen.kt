package com.example.pokemonappagilecontent.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemonappagilecontent.components.LoadingDialog
import com.example.pokemonappagilecontent.ui.theme.PokemonAppAgileContentTheme
import kotlinx.coroutines.launch
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

    //logic to avoid double call
    if (state.pokemons.size == 0) {
        LaunchedEffect(Unit) {
            viewModel.loadNextPokemonPage()
        }
    }
}

@Composable
fun ListPokemons(
    state: ListPokemonsUiState = ListPokemonsUiState(),
    onNavigateToDetails: (String) -> Unit = {},
    viewModel: ListPokemonsViewModel
) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
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
                    modifier = Modifier.padding(16.dp)
                )
            }

            if (state.searchHasFinished()) {
                LaunchedEffect(Unit) {
                    scope.launch {
                        snackbarHostState.showSnackbar(state.pokemons.size.toString())
                    }
                }

                state.pokemons.let { pokemons ->
                    LazyColumn(
                        modifier = Modifier.testTag("POKEMON_LIST")
                    ) {
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
}

@Preview
@Composable
fun ListPokemonsPreview() {
    val viewModel: ListPokemonsViewModel = koinViewModel()
    val state by viewModel.uiState.collectAsState()

    PokemonAppAgileContentTheme {
        ListPokemons(
            state = state,
            onNavigateToDetails = { },
            viewModel = viewModel
        )
    }
}