package com.example.data.api.datasource

import com.example.core.datasource.PokemonDataSource
import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity
import com.example.data.api.retrofit.PokemonAPI
import com.example.data.api.mapper.toPokemonDetail
import com.example.data.api.mapper.toPokemonEntity

class PokemonDataSourceImpl(val api: PokemonAPI): PokemonDataSource {

    override suspend fun getPokemonPageList(startIndex: Int, itensCount: Int): List<PokemonItemEntity> {
        return api.listAll(startIndex, itensCount).results.map { it.toPokemonEntity() }
    }

    override suspend fun getByName(name: String): PokemonDetailEntity {
        return api.findByName(name).toPokemonDetail()
    }
}