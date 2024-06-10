package com.example.data.api.retrofit

import com.example.data.api.response.ListPokemonsPageResponse
import com.example.data.api.response.PokemonDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAppService {

    @GET("/api/v2/pokemon/")
    suspend fun getPokemonList(@Query("offset") offset: Int, @Query("limit") limit: Int): ListPokemonsPageResponse

    @GET("/api/v2/pokemon/{name}")
    suspend fun findByName(@Path("name") name: String): PokemonDetailResponse
}