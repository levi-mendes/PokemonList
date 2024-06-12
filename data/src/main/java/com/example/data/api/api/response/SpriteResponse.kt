package com.example.data.api.api.response

import com.squareup.moshi.Json

data class SpriteResponse(
    @field:Json(name = "front_default")
    val url: String
)