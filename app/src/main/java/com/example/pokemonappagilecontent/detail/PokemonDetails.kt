package com.example.pokemonappagilecontent.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.pokemonappagilecontent.ui.theme.PokemonAppAgileContentTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonDetail(
    name: String,
    viewModel: PokemonDetailViewModel = koinViewModel(),
) {
    val state by viewModel.uiState.collectAsState()

    PokemonDetail(state = state)
    LaunchedEffect(Unit) {
        viewModel.getPokemonDetailByName(name)
    }
}

@Composable
fun PokemonDetail(
    state: PokemonDetailUiState = PokemonDetailUiState(),
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
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

        state.error?.message?.let { errorMessage ->
            Text(
                text = errorMessage,
                color = Color.Red,
                textAlign = TextAlign.Center,
                style = typography.titleLarge,
                modifier = Modifier
                    .padding(16.dp)
            )
        }

        state.pokemonDetail?.let { pokemonDetail ->
            val imageUrl = pokemonDetail.imageUrl

            val imageRequest = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .memoryCacheKey(imageUrl)
                .diskCacheKey(imageUrl)
                .error(drawableResId = android.R.drawable.stat_notify_error)
                .diskCachePolicy(CachePolicy.ENABLED)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .build()


            AsyncImage(
                model = imageRequest,
                contentDescription = null,
                Modifier
                    .width(200.dp)
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            val columnModifier = Modifier.padding(vertical = 8.dp)
            Column {
                Row(modifier = columnModifier) {
                    Text(text = "Id: ")
                    Text(text = pokemonDetail.id.toString())
                }
                Divider()
                Row(modifier = columnModifier) {
                    Text(text = "Name: ")
                    Text(text = pokemonDetail.name.replaceFirstChar { it.uppercase() })
                }
                Divider()
                Row(modifier = columnModifier) {
                    Text(text = "Weight: ")
                    Text(text = pokemonDetail.weight.toString())
                }
                Divider()
                Row(modifier = columnModifier) {
                    Text(text = "Height: ")
                    Text(text = pokemonDetail.height.toString())
                }
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    val state = PokemonDetailUiState(loading = true)

    PokemonAppAgileContentTheme {
        Surface {
            PokemonDetail(state)
        }
    }
}