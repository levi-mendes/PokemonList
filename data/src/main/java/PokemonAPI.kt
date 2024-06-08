package com.example.data.api

import com.example.data.api.com.example.data.api.mapper.PokemonDetailResponse
import retrofit2.Retrofit

class PokemonAPI(retrofit: Retrofit) {

    private val service by lazy { retrofit.create(PokemonAppService::class.java) }

    suspend fun listAll(startIndex: Int, limit: Int): AllPokemonsResponse {
        return service.getPokemonList(startIndex, limit)
    }

    suspend fun findByName(name: String): PokemonDetailResponse {
        return service.findByName(name)
    }
}