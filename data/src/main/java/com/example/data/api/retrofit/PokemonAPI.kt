package com.example.data.api.retrofit

import com.example.data.api.response.ListPokemonsPageResponse
import com.example.data.api.response.PokemonDetailResponse
import retrofit2.Retrofit

class PokemonAPI(retrofit: Retrofit) {

    companion object {
        const val MAX_ITEMS = 150
    }

    private val service by lazy { retrofit.create(PokemonAppService::class.java) }

    suspend fun listPage(startIndex: Int): ListPokemonsPageResponse {
        return service.getPokemonList(startIndex, MAX_ITEMS)
    }

    suspend fun findByName(name: String): PokemonDetailResponse {
        return service.findByName(name)
    }
}