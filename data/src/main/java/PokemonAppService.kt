package com.example.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAppService {

    @GET("/v2/pokemon/")
    suspend fun listAll(): AllPokemonsDTO

    @GET("/v2/pokemon/{id}")
    suspend fun findByName(@Path("id") id: Int)

    @GET("/v2/pokemon/{name}")
    suspend fun findById(@Path("name") name: String)
}