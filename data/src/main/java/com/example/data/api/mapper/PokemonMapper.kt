package com.example.data.api.mapper

import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity
import com.example.data.api.database.entity.PokemonDB
import com.example.data.api.database.entity.PokemonDetailsDB
import com.example.data.api.api.response.PokemonDetailResponse
import com.example.data.api.api.response.PokemonItemListResponse

fun PokemonItemListResponse.toPokemonEntity(): PokemonItemEntity {
    return PokemonItemEntity().apply {
        name = this@toPokemonEntity.name
    }
}

fun PokemonDetailResponse.toPokemonDetail(): PokemonDetailEntity {
    return PokemonDetailEntity(
        id = id,
        name = name,
        weight = weight,
        height = height,
        imageUrl = sprites.url
    )
}

fun PokemonDetailEntity.toPokemonDetailDB(): PokemonDetailsDB {
    return PokemonDetailsDB(
        id = id,
        name = name,
        url = imageUrl,
        weight = weight,
        height = height
    )
}

fun PokemonDetailsDB.toPokemonDetailDB(): PokemonDetailEntity {
    return PokemonDetailEntity(
        id = id,
        name = name,
        imageUrl = url,
        weight = weight,
        height = height
    )
}

fun PokemonDB.toPokemonItemEntity(): PokemonItemEntity {
    return PokemonItemEntity().apply {
        name = this@toPokemonItemEntity.name
    }
}

fun PokemonItemEntity.toPokemonItemEntity(page: Int) =
    PokemonDB(page = page, name = name)