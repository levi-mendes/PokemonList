package com.example.core.detail

import com.example.core.datasource.local.PokemonDetailsDataSourceLocal

class GetPokemonDetailLocalUseCase(private val dao: PokemonDetailsDataSourceLocal) {

    suspend fun getByName(name: String): PokemonDetailEntity? {
        return dao.getByName(name)
    }
}