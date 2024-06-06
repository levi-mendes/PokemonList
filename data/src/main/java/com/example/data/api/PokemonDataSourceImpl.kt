package com.example.data.api.com.example.data.api

import com.example.core.PokemonDataSource
import com.example.core.PokemonEntity
import com.example.data.api.PokemonAPI
import com.example.data.api.com.example.data.api.mapper.toPokemonEntity

class PokemonDataSourceImpl(val api: PokemonAPI): PokemonDataSource {
    override suspend fun listAll(): List<PokemonEntity> {
        return api.listAll().results.map { it.toPokemonEntity() }
    }

    override suspend fun getByName(name: String): PokemonEntity {
        return api.findByName(name).toPokemonEntity()
    }
}