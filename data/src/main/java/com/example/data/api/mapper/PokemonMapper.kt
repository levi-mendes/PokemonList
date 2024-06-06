package com.example.data.api.com.example.data.api.mapper

import com.example.core.PokemonEntity
import com.example.data.api.com.example.data.api.PokemonResponse


fun PokemonResponse.toPokemonEntity(): PokemonEntity {
    val pokemonEntity = PokemonEntity()
    pokemonEntity.name = name

    return pokemonEntity
}