package com.example.data.api.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonDetailsDB(
    @PrimaryKey
    var name: String,
    var url: String
)