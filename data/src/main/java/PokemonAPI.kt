package com.example.data.api

import com.example.data.api.com.example.data.api.PokemonResponse
import retrofit2.Retrofit

class PokemonAPI(retrofit: Retrofit) {

    private val service by lazy { retrofit.create(PokemonAppService::class.java) }

    suspend fun listAll(): AllPokemonsResponse {
        return service.listAll()
    }

    suspend fun findByName(name: String): PokemonResponse {
        return service.findByName(name)
    }
}