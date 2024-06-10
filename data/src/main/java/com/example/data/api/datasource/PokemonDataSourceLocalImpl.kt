package com.example.data.api.datasource

import com.example.core.datasource.local.PokemonDataSourceLocal
import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity
import com.example.data.api.database.dao.PokemonDao
import com.example.data.api.mapper.toPokemonDetailEntity
import com.example.data.api.mapper.toPokemonItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonDataSourceLocalImpl(private val dao: PokemonDao): PokemonDataSourceLocal {

    override suspend fun getPokemonPageList(page: Int): List<PokemonItemEntity> {
        return withContext(Dispatchers.IO) {
            dao.getPokemonList(page).map { it.toPokemonItemEntity() }
        }
    }

    override suspend fun getByName(name: String): PokemonDetailEntity {
        return withContext(Dispatchers.IO) {
            dao.getPokemonDetails(name).toPokemonDetailEntity()
        }
    }

    override suspend fun savePage(page: Int, pokemons: List<PokemonItemEntity>) {
        withContext(Dispatchers.IO) {
            dao.savePageItems(*pokemons.map { it.toPokemonItemEntity(page) }.toTypedArray())
        }
    }
}