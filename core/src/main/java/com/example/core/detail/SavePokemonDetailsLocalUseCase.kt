package com.example.core.detail

import com.example.core.datasource.local.PokemonDetailsDataSourceLocal

class SavePokemonDetailsLocalUseCase(private val dataSource: PokemonDetailsDataSourceLocal) {

    suspend fun save(pokemon: PokemonDetailEntity) {
        dataSource.save(pokemon)
    }
}