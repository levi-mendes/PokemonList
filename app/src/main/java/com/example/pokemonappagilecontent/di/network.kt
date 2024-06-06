package com.example.pokemonappagilecontent.di

import com.example.data.api.PokemonAPI
import com.example.data.api.RetrofitInitializer
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val network = module {
    single { RetrofitInitializer.getInstance() }
    singleOf(::PokemonAPI)
}