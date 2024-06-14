package com.example.pokemonappagilecontent.list

import com.example.core.list.PokemonItemEntity

data class ListPokemonsUiState(
    var loading: Boolean = false,
    var pokemons: MutableList<PokemonItemEntity> =  mutableListOf(),
    val error: Throwable? = null,
)