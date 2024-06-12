package com.example.core.datasource.local

import com.example.core.list.PokemonItemEntity

interface PokemonDataSourceLocal {

    suspend fun getPokemonPageList(page: Int): List<PokemonItemEntity>

    suspend fun savePage(page: Int, pokemons: List<PokemonItemEntity>)
}