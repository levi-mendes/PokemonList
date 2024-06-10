package com.example.core.datasource.local

import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity

interface PokemonDataSourceLocal {

    suspend fun getPokemonPageList(page: Int): List<PokemonItemEntity>

    suspend fun getByName(name: String): PokemonDetailEntity

    suspend fun savePage(page: Int, pokemons: List<PokemonItemEntity>)
}