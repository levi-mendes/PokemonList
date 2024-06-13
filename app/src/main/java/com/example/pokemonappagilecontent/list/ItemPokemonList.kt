package com.example.pokemonappagilecontent.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.list.PokemonItemEntity
import com.example.pokemonappagilecontent.fakedata.listPokemonItemEntityFake
import com.example.pokemonappagilecontent.ui.theme.PokemonAppAgileContentTheme

@Composable
fun ItemPokemonList(
    modifier: Modifier = Modifier,
    onItemClicked: (String) -> Unit,
    pokemon: PokemonItemEntity
) {
    Column(
        modifier.fillMaxWidth()
            .clickable {
                onItemClicked(pokemon.name)
            }

    ) {
        Text(
            text = pokemon.name.replaceFirstChar { it.uppercase() },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
        )
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPokemonListPreview() {
    PokemonAppAgileContentTheme {
        ItemPokemonList(
            pokemon = listPokemonItemEntityFake.first(),
            onItemClicked = {}
        )
    }
}
