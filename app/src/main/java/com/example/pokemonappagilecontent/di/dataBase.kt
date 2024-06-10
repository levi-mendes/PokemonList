package com.example.pokemonappagilecontent.di

import com.example.data.api.database.PokemonDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

var dataBase = module {

    single { PokemonDatabase.getInstance(context = androidContext()) }
    singleOf(PokemonDatabase::pokemonDao)
    singleOf(PokemonDatabase::pokemonDetailsDao)
}