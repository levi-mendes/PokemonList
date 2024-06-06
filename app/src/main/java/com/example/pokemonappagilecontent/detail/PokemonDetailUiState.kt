package com.example.pokemonappagilecontent.detail

import com.example.core.PokemonDetailEntity

data class PokemonDetailUiState(
    val loading: Boolean = false,
    var pokemonDetail: PokemonDetailEntity? = null,
    val error: Throwable? = null
)