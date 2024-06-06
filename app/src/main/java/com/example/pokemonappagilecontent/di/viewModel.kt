package com.example.pokemonappagilecontent.di

import com.example.pokemonappagilecontent.list.ListPokemonsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {

    viewModel {
        ListPokemonsViewModel(
            listAll = get()
        )
    }
}