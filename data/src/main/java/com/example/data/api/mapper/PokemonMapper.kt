package com.example.data.api.mapper

import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity
import com.example.data.api.database.entity.PokemonDB
import com.example.data.api.response.PokemonDetailResponse
import com.example.data.api.response.PokemonItemListResponse

fun PokemonItemListResponse.toPokemonEntity(): PokemonItemEntity {
    return PokemonItemEntity().apply {
        name = this@toPokemonEntity.name
    }
}

fun PokemonDetailResponse.toPokemonDetail(): PokemonDetailEntity {
    return PokemonDetailEntity().apply {
        name = this@toPokemonDetail.name
        imageUrl = this@toPokemonDetail.sprites.url
    }
}

fun PokemonDB.toPokemonItemEntity(): PokemonItemEntity {
    return PokemonItemEntity().apply {
        name = this@toPokemonItemEntity.name
    }
}

fun PokemonDB.toPokemonDetailEntity(): PokemonDetailEntity {
    return PokemonDetailEntity().apply {
        name = this@toPokemonDetailEntity.name
    }
}

fun PokemonItemEntity.toPokemonItemEntity(page: Int) =
    PokemonDB(page = page, name = name)