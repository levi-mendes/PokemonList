package com.example.pokemonappagilecontent

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokemonappagilecontent.ui.theme.PokemonAppAgileContentTheme

@Composable
fun PokemonDetail() {
    Text(text = "Detalhes")
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    PokemonAppAgileContentTheme {
        PokemonDetail()
    }
}