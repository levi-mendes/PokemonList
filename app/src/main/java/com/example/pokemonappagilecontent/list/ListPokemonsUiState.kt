package com.example.pokemonappagilecontent.list

import com.example.core.PokemonItemEntity

data class ListPokemonsUiState(
    val loading: Boolean = false,
    var currentItensCount: Int = 0,
    val pokemons: List<PokemonItemEntity>? = emptyList(),
    val error: Throwable? = null
)