package com.example.pokemonappagilecontent

import android.app.Application
import com.example.pokemonappagilecontent.di.dataSource
import com.example.pokemonappagilecontent.di.useCases
import com.example.pokemonappagilecontent.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonAppAgileContentApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(arrayListOf(
                viewModel,
                useCases,
                dataSource
            ))
            androidContext(this@PokemonAppAgileContentApplication)
        }
    }
}