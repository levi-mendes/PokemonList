package com.example.pokemonappagilecontent.di

import com.example.core.ListPokemonPageUseCase
import com.example.core.GetPokemonDetailUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCases = module {
    singleOf(::GetPokemonDetailUseCase)
    singleOf(::ListPokemonPageUseCase)

}