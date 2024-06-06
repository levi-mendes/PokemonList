package com.example.pokemonappagilecontent.di

import com.example.core.PokemonDataSource
import com.example.data.api.com.example.data.api.PokemonDataSourceImpl
import org.koin.dsl.module

val dataSource = module {

    single<PokemonDataSource> { PokemonDataSourceImpl(api = get()) }
}