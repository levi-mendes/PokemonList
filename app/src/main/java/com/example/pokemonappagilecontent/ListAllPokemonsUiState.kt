package com.example.pokemonappagilecontent

import com.example.core.PokemonItemEntity

data class ListAllPokemonsUiState(
    val loading: Boolean = false,
    var currentItensCount: Int = 0,
    val pokemons: List<PokemonItemEntity>? = emptyList(),
    val error: Throwable? = null
)