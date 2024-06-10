package com.example.pokemonappagilecontent.di

import com.example.core.datasource.local.PokemonDataSourceLocal
import com.example.core.datasource.remote.PokemonDataSource
import com.example.data.api.datasource.PokemonDataSourceImpl
import com.example.data.api.datasource.PokemonDataSourceLocalImpl
import org.koin.dsl.module

val dataSource = module {

    single<PokemonDataSource> { PokemonDataSourceImpl(api = get()) }
    single<PokemonDataSourceLocal> { PokemonDataSourceLocalImpl(dao = get()) }
}