package com.example.pokemonappagilecontent.di

import com.example.core.list.ListPokemonPageUseCase
import com.example.core.detail.GetPokemonDetailUseCase
import com.example.core.detail.GetPokemonDetailLocalUseCase
import com.example.core.detail.SavePokemonDetailsLocalUseCase
import com.example.core.list.ListPokemonPageLocalUseCase
import com.example.core.list.SavePokemonPageLocalUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCases = module {
    singleOf(::GetPokemonDetailUseCase)
    singleOf(::GetPokemonDetailLocalUseCase)
    singleOf(::SavePokemonDetailsLocalUseCase)

    singleOf(::ListPokemonPageUseCase)
    singleOf(::ListPokemonPageLocalUseCase)
    singleOf(::SavePokemonPageLocalUseCase)
}