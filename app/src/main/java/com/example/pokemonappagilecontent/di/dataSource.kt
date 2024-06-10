package com.example.pokemonappagilecontent.di

import com.example.core.datasource.PokemonDataSource
import com.example.data.api.datasource.PokemonDataSourceImpl
import org.koin.dsl.module

val dataSource = module {

    single<PokemonDataSource> { PokemonDataSourceImpl(api = get()) }
}