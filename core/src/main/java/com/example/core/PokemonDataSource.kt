package com.example.core

interface PokemonDataSource {

    suspend fun getPokemonPageList(startIndex: Int, itensCount: Int): List<PokemonEntity>

    suspend fun getByName(name: String): PokemonEntity
}