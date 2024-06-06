package com.example.pokemonappagilecontent.di

import com.example.pokemonappagilecontent.ListAllPokemonsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {

    viewModel {
        ListAllPokemonsViewModel(
            listAll = get()
        )
    }
}