package com.example.data.api.com.example.data.api

import com.example.core.PokemonDataSource
import com.example.core.PokemonDetailEntity
import com.example.core.PokemonItemEntity
import com.example.data.api.PokemonAPI
import com.example.data.api.com.example.data.api.mapper.toPokemonDetail
import com.example.data.api.com.example.data.api.mapper.toPokemonEntity

class PokemonDataSourceImpl(val api: PokemonAPI): PokemonDataSource {

    override suspend fun getPokemonPageList(startIndex: Int, itensCount: Int): List<PokemonItemEntity> {
        return api.listAll(startIndex, itensCount).results.map { it.toPokemonEntity() }
    }

    override suspend fun getByName(name: String): PokemonDetailEntity {
        return api.findByName(name).toPokemonDetail()
    }
}