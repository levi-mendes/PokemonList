package com.example.core

class ListPokemonUseCase(val dataSource: PokemonDataSource) {

   fun listAll(): AllPokemonEntity {
        return dataSource.listAll()
   }
}