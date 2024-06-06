package com.example.pokemonappagilecontent

import com.example.core.AllPokemonEntity
import com.example.core.PokemonEntity

data class ListAllPokemonsUiState(
    val loading: Boolean = false,
    val pokemons: List<PokemonEntity> = emptyList(),
    val error: Throwable? = null
)