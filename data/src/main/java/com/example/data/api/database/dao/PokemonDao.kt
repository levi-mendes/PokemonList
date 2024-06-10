package com.example.data.api.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.api.database.entity.PokemonDB

@Dao
interface PokemonDao {

    @Query("Select * from PokemonDB where page = :page")
    fun getPokemonList(page: Int): List<PokemonDB>

    @Query("Select * from PokemonDB where name = :name")
    fun getPokemonDetails(name: String): PokemonDB

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePageItems(vararg items: PokemonDB)
}