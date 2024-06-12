package com.example.data.api.api.response

import com.squareup.moshi.Json

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val sprites: SpriteResponse,
    val weight: Double,
    val height: Double
)

data class SpriteResponse(
    val other: OtherResponse
)

data class OtherResponse(
    val home: HomeResponse
)

data class HomeResponse(
    @field:Json(name = "front_default")
    val frontDefault: String
)

