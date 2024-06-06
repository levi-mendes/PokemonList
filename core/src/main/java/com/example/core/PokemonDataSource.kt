package com.example.core

interface PokemonDataSource {

    suspend fun getPokemonPageList(startIndex: Int, itensCount: Int): List<PokemonItemEntity>

    suspend fun getByName(name: String): PokemonItemEntity
}