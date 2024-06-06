package com.example.data.api.com.example.data.api.mapper

import com.example.core.PokemonItemEntity
import com.example.data.api.com.example.data.api.PokemonResponse


fun PokemonResponse.toPokemonEntity(): PokemonItemEntity {
    val pokemonItemEntity = PokemonItemEntity()
    pokemonItemEntity.name = name

    return pokemonItemEntity
}