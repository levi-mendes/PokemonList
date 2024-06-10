package com.example.core.detail

import com.example.core.datasource.remote.PokemonDataSource

class GetPokemonDetailUseCase(private val dataSource: PokemonDataSource) {

   suspend fun getPokemonDetail(name: String): PokemonDetailEntity {
        return dataSource.getByName(name)
   }
}