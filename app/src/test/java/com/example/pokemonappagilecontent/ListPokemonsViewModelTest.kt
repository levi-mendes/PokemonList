package com.example.pokemonappagilecontent

import com.example.core.list.ListPokemonPageLocalUseCase
import com.example.core.list.ListPokemonPageUseCase
import com.example.core.list.SavePokemonPageLocalUseCase
import com.example.pokemonappagilecontent.list.ListPokemonsViewModel
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ListPokemonsViewModelTest {

    private val getPokemonPage: ListPokemonPageUseCase = mockk()
    private val getPokemonPageLocal: ListPokemonPageLocalUseCase = mockk()
    private val savePokemonPageLocal: SavePokemonPageLocalUseCase = mockk()
    private lateinit var viewModel: ListPokemonsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.IO)
        viewModel = ListPokemonsViewModel(getPokemonPage, getPokemonPageLocal, savePokemonPageLocal)
    }

    @Test
    fun nextPageCounterShouldBeZeroInInitiaization() {
        assertEquals(0, viewModel.nextPage)
    }
}