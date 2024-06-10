package com.example.data.api.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.api.database.entity.PokemonDetailsDB

@Dao
interface PokemonDetailsDao {

    @Query("Select * from PokemonDetailsDB where name = :name")
    fun getDetails(name: String): PokemonDetailsDB?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(pokemon: PokemonDetailsDB)
}