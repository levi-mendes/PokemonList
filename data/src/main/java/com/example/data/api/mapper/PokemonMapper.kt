package com.example.data.api.com.example.data.api.mapper

import com.example.core.PokemonDetailEntity
import com.example.core.PokemonItemEntity
import com.example.data.api.com.example.data.api.PokemonItemListResponse

fun PokemonItemListResponse.toPokemonEntity(): PokemonItemEntity {
    val pokemonItemEntity = PokemonItemEntity()
    pokemonItemEntity.name = name

    return pokemonItemEntity
}

fun PokemonDetailResponse.toPokemonDetail(): PokemonDetailEntity {
    val pokemonDetail = PokemonDetailEntity()
    pokemonDetail.name = name
    pokemonDetail.imageUrl = sprites.front_default//TODO

    return pokemonDetail
}