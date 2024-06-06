package com.example.core

class ListPokemonUseCase(val dataSource: PokemonDataSource) {

   suspend fun listPokemonPage(startIndex: Int, itensCount: Int): List<PokemonItemEntity> {
        return dataSource.getPokemonPageList(startIndex, itensCount)
   }
}