package com.example.data.api

import com.example.data.api.com.example.data.api.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAppService {

    @GET("/api/v2/pokemon/")
    suspend fun getPokemonList(@Query("offset") offset: Int, @Query("limit") limit: Int): AllPokemonsResponse

    @GET("/api/v2/pokemon/{name}")
    suspend fun findByName(@Path("name") name: String): PokemonResponse
}