package com.example.core.list

import com.example.core.datasource.remote.PokemonDataSource

class ListPokemonPageUseCase(private val dataSource: PokemonDataSource) {

   suspend fun listPokemonPage(startIndex: Int): List<PokemonItemEntity> {
        return dataSource.getPokemonPageList(startIndex)
   }
}