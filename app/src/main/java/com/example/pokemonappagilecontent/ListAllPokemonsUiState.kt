package com.example.pokemonappagilecontent

import com.example.core.AllPokemonEntity

data class ListAllPokemonsUiState(
    val loading: Boolean = false,
    val pokemons: AllPokemonEntity? = null,
    val error: Throwable? = null
)