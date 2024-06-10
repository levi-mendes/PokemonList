package com.example.data.api.response

import com.example.data.api.response.SpriteResponse

data class PokemonDetailResponse(
    val name: String,
    val sprites: SpriteResponse
)