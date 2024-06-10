package com.example.core.list

import com.example.core.datasource.local.PokemonDataSourceLocal

class SavePokemonPageLocalUseCase(private val dataSource: PokemonDataSourceLocal) {

    suspend fun savePage(page: Int, items: List<PokemonItemEntity>) {
        return dataSource.savePage(page, items)
    }
}