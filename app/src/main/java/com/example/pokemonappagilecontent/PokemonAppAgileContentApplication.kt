package com.example.pokemonappagilecontent

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.annotation.ExperimentalCoilApi
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.util.DebugLogger
import com.example.pokemonappagilecontent.di.dataBase
import com.example.pokemonappagilecontent.di.dataSource
import com.example.pokemonappagilecontent.di.network
import com.example.pokemonappagilecontent.di.useCases
import com.example.pokemonappagilecontent.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonAppAgileContentApplication: Application(), ImageLoaderFactory {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(arrayListOf(
                viewModel,
                useCases,
                dataSource,
                network,
                dataBase
            ))
            androidContext(this@PokemonAppAgileContentApplication)
        }
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.20)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(cacheDir.resolve("image_cache"))
                    .maxSizeBytes(5 * 1024 * 1024)
                    .build()
            }
            .logger(DebugLogger())
            .respectCacheHeaders(false)
            .build()
    }
}