package com.example.core

class ListPokemonUseCase(val dataSource: PokemonDataSource) {

   suspend fun listAll(): List<PokemonEntity> {
        return dataSource.listAll()
   }
}