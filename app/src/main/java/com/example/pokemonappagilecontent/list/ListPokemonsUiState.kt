package com.example.pokemonappagilecontent.list

import com.example.core.list.PokemonItemEntity

data class ListPokemonsUiState(
    val loading: Boolean = false,
    val pokemons: MutableList<PokemonItemEntity> =  mutableListOf(),
    val error: Throwable? = null,
    val isNewResultSearch: Boolean = false
) {
    fun searchHasFinished(): Boolean {
        return !loading && isNewResultSearch
    }
}