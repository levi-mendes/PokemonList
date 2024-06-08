package com.example.core

class ListPokemonPageUseCase(private val dataSource: PokemonDataSource) {

   suspend fun listPokemonPage(startIndex: Int, itensCount: Int): List<PokemonItemEntity> {
        return dataSource.getPokemonPageList(startIndex, itensCount).sortedBy { it.name }
   }
}