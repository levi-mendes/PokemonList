package com.example.pokemonappagilecontent.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.core.detail.PokemonDetailEntity
import com.example.pokemonappagilecontent.ui.theme.PokemonAppAgileContentTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonDetail(
    name: String,
    viewModel: PokemonDetailViewModel = koinViewModel(),
) {
    val state by viewModel.uiState.collectAsState()

    PokemonDetail(state = state)
    viewModel.getPokemonDetailByName(name)
}

@Composable
fun PokemonDetail(
    state: PokemonDetailUiState = PokemonDetailUiState(),
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp),
                strokeWidth = 4.dp
            )
        }

        state.pokemonDetail?.let { pokemonDetail ->
            AsyncImage(
                model = pokemonDetail.imageUrl,
                contentDescription = null,
                Modifier
                    .width(200.dp)
                    .height(200.dp),
                //placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )

            Row {
                Text(text = "Name: ")
                Text(text = pokemonDetail.name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    val pokemonDetail = PokemonDetailEntity()
    val state = PokemonDetailUiState()
    state.pokemonDetail = pokemonDetail

    PokemonAppAgileContentTheme {
        PokemonDetail(state)
    }
}