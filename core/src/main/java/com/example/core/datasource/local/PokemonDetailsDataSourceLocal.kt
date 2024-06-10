package com.example.core.datasource.local

import com.example.core.detail.PokemonDetailEntity

interface PokemonDetailsDataSourceLocal {

    suspend fun getByName(name: String): PokemonDetailEntity?

    suspend fun save(pokemmon: PokemonDetailEntity)
}