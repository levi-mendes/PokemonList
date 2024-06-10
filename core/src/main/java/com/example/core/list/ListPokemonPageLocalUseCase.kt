package com.example.core.list

import com.example.core.datasource.local.PokemonDataSourceLocal

class ListPokemonPageLocalUseCase(private val dataSource: PokemonDataSourceLocal) {

    suspend fun listPokemonPage(page: Int): List<PokemonItemEntity> {
        return dataSource.getPokemonPageList(page)
    }
}