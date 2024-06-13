package com.example.pokemonappagilecontent

import com.example.core.list.ListPokemonPageLocalUseCase
import com.example.core.list.ListPokemonPageUseCase
import com.example.core.list.SavePokemonPageLocalUseCase
import com.example.pokemonappagilecontent.fakedata.listPokemonItemEntityFake
import com.example.pokemonappagilecontent.list.ListPokemonsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class ListPokemonsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getPokemonPage: ListPokemonPageUseCase = mockk {
        coEvery { listPokemonPage(any()) } returns listPokemonItemEntityFake
    }

    private val getPokemonPageLocal: ListPokemonPageLocalUseCase = mockk {
        coEvery { listPokemonPage(any()) } returns listPokemonItemEntityFake
    }

    private val savePokemonPageLocal: SavePokemonPageLocalUseCase = mockk {
        coEvery { savePage(any(), any()) } returns mockk()
    }

    private lateinit var viewModel: ListPokemonsViewModel

    @Before
    fun setup() {

    }

    @Test
    fun nextPageCounterShouldBeZeroInInitiaization() {
        viewModel = ListPokemonsViewModel(getPokemonPage, getPokemonPageLocal, savePokemonPageLocal)
        assertEquals(0, viewModel.nextPage)
    }

    @Test
    fun `nextPage should be incremented after constructor call`() = runTest {
        val viewModel = ListPokemonsViewModel(getPokemonPage, getPokemonPageLocal, savePokemonPageLocal)
        viewModel.loadNextPokemonPage()
        assertEquals(1, viewModel.nextPage)
    }
}