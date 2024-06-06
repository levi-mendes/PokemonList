package com.example.data.api

import com.example.data.api.com.example.data.api.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAppService {

    @GET("/api/v2/pokemon/")
    suspend fun listAll(): AllPokemonsResponse

    @GET("/api/v2/pokemon/{name}")
    suspend fun findByName(@Path("name") name: String): PokemonResponse
}