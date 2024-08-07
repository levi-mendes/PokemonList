package com.example.data.api.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.api.database.dao.PokemonDao
import com.example.data.api.database.dao.PokemonDetailsDao
import com.example.data.api.database.entity.PokemonDB
import com.example.data.api.database.entity.PokemonDetailsDB

@Database(entities = [PokemonDB::class, PokemonDetailsDB::class], version = 3)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonDetailsDao(): PokemonDetailsDao

    companion object {

        private var database: PokemonDatabase? = null
        private const val DATABASE_NAME = "pokemon-db"

        fun getInstance(context: Context): PokemonDatabase {
            return database ?: createDatabase(context).also {
                database = it
            }
        }

        private fun createDatabase(context: Context): PokemonDatabase {
            return Room.databaseBuilder(context, PokemonDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}