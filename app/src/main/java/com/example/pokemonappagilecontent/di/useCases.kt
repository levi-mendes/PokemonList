package com.example.pokemonappagilecontent.di

import com.example.core.list.ListPokemonPageUseCase
import com.example.core.detail.GetPokemonDetailUseCase
import com.example.core.list.ListPokemonPageLocalUseCase
import com.example.core.list.SavePokemonPageLocalUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCases = module {
    singleOf(::GetPokemonDetailUseCase)
    singleOf(::ListPokemonPageUseCase)
    singleOf(::ListPokemonPageLocalUseCase)
    singleOf(::SavePokemonPageLocalUseCase)
}