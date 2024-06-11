package com.example.data.api.datasource

import com.example.core.datasource.remote.PokemonDataSource
import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity
import com.example.data.api.retrofit.PokemonAPI
import com.example.data.api.mapper.toPokemonDetail
import com.example.data.api.mapper.toPokemonEntity

class PokemonDataSourceImpl(val api: PokemonAPI): PokemonDataSource {

    override suspend fun getPokemonPageList(startIndex: Int): List<PokemonItemEntity> {
        return api.listPage(startIndex).results.map { it.toPokemonEntity() }
    }

    override suspend fun getByName(name: String): PokemonDetailEntity {
        return api.findByName(name).toPokemonDetail()
    }
}