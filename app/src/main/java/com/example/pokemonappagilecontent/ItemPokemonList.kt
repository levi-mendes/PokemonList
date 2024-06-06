package com.example.pokemonappagilecontent

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.PokemonEntity

@Composable
fun ItemPokemonList(
    modifier: Modifier = Modifier,
    pokemon: PokemonEntity
) {
    Text(text = pokemon.name)
}

@Preview(showBackground = true)
@Composable
fun ItemPokemonListPreview() {
    val pokemon = PokemonEntity()
    pokemon.name = "Pikatchu"

    ItemPokemonList(pokemon = pokemon)
}
