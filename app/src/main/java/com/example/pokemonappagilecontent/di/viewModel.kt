package com.example.pokemonappagilecontent.di

import com.example.pokemonappagilecontent.list.ListPokemonsViewModel
import com.example.pokemonappagilecontent.detail.PokemonDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModel = module {

    viewModelOf(::ListPokemonsViewModel)
    viewModelOf(::PokemonDetailViewModel)
}