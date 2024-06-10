package com.example.pokemonappagilecontent.di

import com.example.data.api.retrofit.PokemonAPI
import com.example.data.api.retrofit.RetrofitInitializer
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val network = module {
    single { RetrofitInitializer.getInstance() }
    singleOf(::PokemonAPI)
}