package com.example.pokemonappagilecontent.di

import com.example.pokemonappagilecontent.detail.PokemonDetailViewModel
import com.example.pokemonappagilecontent.list.ListPokemonsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {

    viewModel {
        ListPokemonsViewModel(
            getPokemonPage = get(), getPokemonPageLocal = get(),
            savePokemonPageLocal = get()
        )
    }
    viewModel {
        PokemonDetailViewModel(
            getPokemonDetailUseCase = get(), getPokemonDetailLocalUseCase = get(),
            savePokemonDetailLocalUseCase = get()
        )
    }
}