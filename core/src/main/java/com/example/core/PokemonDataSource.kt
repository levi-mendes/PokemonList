package com.example.core

interface PokemonDataSource {

    suspend fun listAll(): List<PokemonEntity>

    suspend fun getByName(name: String): PokemonEntity
}