package com.example.data.api.response

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val sprites: SpriteResponse,
    val weight: Double,
    val height: Double
)