package com.example.data.api.datasource

import com.example.core.datasource.local.PokemonDetailsDataSourceLocal
import com.example.core.detail.PokemonDetailEntity
import com.example.data.api.database.dao.PokemonDetailsDao
import com.example.data.api.mapper.toPokemonDetailDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonDetailDataSourceLocalImpl(private val dao: PokemonDetailsDao): PokemonDetailsDataSourceLocal {
    override suspend fun getByName(name: String): PokemonDetailEntity? {
        return withContext(Dispatchers.IO) {
            dao.getDetails(name)?.toPokemonDetailDB()
        }
    }

    override suspend fun save(pokemmon: PokemonDetailEntity) {
        withContext(Dispatchers.IO) {
            dao.save(pokemmon.toPokemonDetailDB())
        }
    }
}