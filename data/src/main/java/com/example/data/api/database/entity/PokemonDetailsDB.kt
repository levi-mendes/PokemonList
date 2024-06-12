package com.example.data.api.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonDetailsDB(
    @PrimaryKey
    val id: Int,
    val name: String,
    val url: String,
    val weight: Double,
    val height: Double
)