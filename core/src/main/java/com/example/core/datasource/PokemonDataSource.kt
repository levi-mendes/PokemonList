package com.example.core.datasource

import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity

interface PokemonDataSource {

    suspend fun getPokemonPageList(startIndex: Int, itensCount: Int): List<PokemonItemEntity>

    suspend fun getByName(name: String): PokemonDetailEntity
}