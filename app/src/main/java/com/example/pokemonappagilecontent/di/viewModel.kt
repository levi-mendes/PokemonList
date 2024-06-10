package com.example.pokemonappagilecontent.di

import com.example.pokemonappagilecontent.list.ListPokemonsViewModel
import com.example.pokemonappagilecontent.detail.PokemonDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModel = module {

    viewModel {
        ListPokemonsViewModel(
            getPokemonPage = get(), getPokemonPageLocal = get(),
            savePokemonPageLocal = get()
        )
    }
    viewModelOf(::PokemonDetailViewModel)
}