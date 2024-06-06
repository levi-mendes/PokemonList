package com.example.core

class GetPokemonDetailUseCase(val dataSource: PokemonDataSource) {

   suspend fun getPokemonDetail(name: String): PokemonDetailEntity {
        return dataSource.getByName(name)
   }
}