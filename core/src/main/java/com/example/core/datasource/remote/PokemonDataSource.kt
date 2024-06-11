package com.example.core.datasource.remote

import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity

interface PokemonDataSource {

    suspend fun getPokemonPageList(startIndex: Int): List<PokemonItemEntity>

    suspend fun getByName(name: String): PokemonDetailEntity
}