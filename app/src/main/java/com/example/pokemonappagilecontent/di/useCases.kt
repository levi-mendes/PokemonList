package com.example.pokemonappagilecontent.di

import com.example.core.ListPokemonUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCases = module {

    singleOf(::ListPokemonUseCase)
}