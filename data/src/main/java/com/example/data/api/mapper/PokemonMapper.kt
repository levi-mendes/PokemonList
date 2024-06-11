package com.example.data.api.mapper

import com.example.core.detail.PokemonDetailEntity
import com.example.core.list.PokemonItemEntity
import com.example.data.api.database.entity.PokemonDB
import com.example.data.api.database.entity.PokemonDetailsDB
import com.example.data.api.response.PokemonDetailResponse
import com.example.data.api.response.PokemonItemListResponse

fun PokemonItemListResponse.toPokemonEntity(): PokemonItemEntity {
    return PokemonItemEntity().apply {
        name = this@toPokemonEntity.name
    }
}

fun PokemonDetailResponse.toPokemonDetail(): PokemonDetailEntity {
    return PokemonDetailEntity().apply {
        id = this@toPokemonDetail.id
        name = this@toPokemonDetail.name
        weight = this@toPokemonDetail.weight
        height = this@toPokemonDetail.height
        imageUrl = this@toPokemonDetail.sprites.url
    }
}

fun PokemonDetailEntity.toPokemonDetailDB(): PokemonDetailsDB {
    return PokemonDetailsDB(name = name, url = imageUrl)
}

fun PokemonDetailsDB.toPokemonDetailDB(): PokemonDetailEntity {
    return PokemonDetailEntity().apply {
        name = this@toPokemonDetailDB.name
        imageUrl = this@toPokemonDetailDB.url
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