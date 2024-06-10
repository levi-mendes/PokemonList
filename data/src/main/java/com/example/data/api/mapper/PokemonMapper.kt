package com.example.data.api.mapper

import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity
import com.example.data.api.response.PokemonDetailResponse
import com.example.data.api.response.PokemonItemListResponse

fun PokemonItemListResponse.toPokemonEntity(): PokemonItemEntity {
    val pokemonItemEntity = PokemonItemEntity()
    pokemonItemEntity.name = name

    return pokemonItemEntity
}

fun PokemonDetailResponse.toPokemonDetail(): PokemonDetailEntity {
    val pokemonDetail = PokemonDetailEntity()
    pokemonDetail.name = name
    pokemonDetail.imageUrl = sprites.url

    return pokemonDetail
}