package com.example.core

interface PokemonDataSource {

    fun listAll(): AllPokemonEntity

    fun getByName(name: String)
}