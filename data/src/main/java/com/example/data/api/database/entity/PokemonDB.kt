package com.example.data.api.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonDB(
    @PrimaryKey
    var name: String,
    var page: Int
)