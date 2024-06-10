package com.example.core.list

import com.example.core.datasource.PokemonDataSource

class ListPokemonPageUseCase(private val dataSource: PokemonDataSource) {

   suspend fun listPokemonPage(startIndex: Int, itensCount: Int): List<PokemonItemEntity> {
        return dataSource.getPokemonPageList(startIndex, itensCount)
   }
}