package com.example.pokemonappagilecontent.di

import com.example.core.datasource.local.PokemonDataSourceLocal
import com.example.core.datasource.local.PokemonDetailsDataSourceLocal
import com.example.core.datasource.remote.PokemonDataSource
import com.example.data.api.database.datasource.PokemonDataSourceImpl
import com.example.data.api.database.datasource.PokemonDataSourceLocalImpl
import com.example.data.api.database.datasource.PokemonDetailDataSourceLocalImpl
import org.koin.dsl.module

val dataSource = module {

    single<PokemonDataSource> { PokemonDataSourceImpl(api = get()) }
    single<PokemonDataSourceLocal> { PokemonDataSourceLocalImpl(dao = get()) }
    single<PokemonDetailsDataSourceLocal> { PokemonDetailDataSourceLocalImpl(dao = get()) }
}