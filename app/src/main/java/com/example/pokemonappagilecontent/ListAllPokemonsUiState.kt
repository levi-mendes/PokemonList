package com.example.pokemonappagilecontent

import com.example.core.PokemonEntity

data class ListAllPokemonsUiState(
    val loading: Boolean = false,
    var currentItensCount: Int = 0,
    val pokemons: List<PokemonEntity>? = emptyList(),
    val error: Throwable? = null
)