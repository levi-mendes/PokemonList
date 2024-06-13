package com.example.pokemonappagilecontent

import com.example.core.list.ListPokemonPageLocalUseCase
import com.example.core.list.ListPokemonPageUseCase
import com.example.core.list.SavePokemonPageLocalUseCase
import com.example.pokemonappagilecontent.fakedata.listPokemonItemEntityFake
import com.example.pokemonappagilecontent.list.ListPokemonsViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class ListPokemonsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getPokemonPageRemote: ListPokemonPageUseCase = mockk {
        coEvery { listPokemonPage(any()) } returns listPokemonItemEntityFake
    }

    private val getPokemonPageLocal: ListPokemonPageLocalUseCase = mockk {
        coEvery { listPokemonPage(any()) } returns listPokemonItemEntityFake
    }

    private val getPokemonPageLocalEmpty: ListPokemonPageLocalUseCase = mockk {
        coEvery { listPokemonPage(any()) } returns emptyList()
    }

    private val savePokemonPageLocal: SavePokemonPageLocalUseCase = mockk {
        coEvery { savePage(any(), any()) } returns mockk()
    }

    private lateinit var viewModel: ListPokemonsViewModel

    @Before
    fun setup() {
        viewModel = ListPokemonsViewModel(getPokemonPageRemote, getPokemonPageLocal, savePokemonPageLocal)
    }

    @Test
    fun `nextPage Counter Should Be Zero In Initialization`() {
        assertEquals(0, viewModel.nextPage)
    }

    @Test
    fun `nextPage should be incremented after loadNextPokemonPage call`() {
        viewModel.loadNextPokemonPage()
        assertEquals(1, viewModel.nextPage)
    }

    @Test
    fun `loading uiState should be false after loadNextPokemonPage menthod call`() {
        viewModel.loadNextPokemonPage()
        assertEquals(false, viewModel.uiState.value.loading)
    }

    @Test
    fun `pokemons uiState should contain at least 150 itens`() {
        viewModel.loadNextPokemonPage()
        assertEquals(150, viewModel.uiState.value.pokemons?.size)
    }

    @Test
    fun `when getPokemonPageLocal-listPokemonPagetpokemons is empty, should  call getPokemonPage-listPokemonPage to ge list remotelly `() {
        viewModel = ListPokemonsViewModel(getPokemonPageRemote, getPokemonPageLocalEmpty, savePokemonPageLocal)
        viewModel.loadNextPokemonPage()
        coVerify { getPokemonPageRemote.listPokemonPage(any()) }
    }

    @Test
    fun `when getPokemonPageRemote is called, savePokemonPageLocal should be called to save returned list locally`() {
        viewModel = ListPokemonsViewModel(getPokemonPageRemote, getPokemonPageLocalEmpty, savePokemonPageLocal)
        viewModel.loadNextPokemonPage()
        coVerify {
            savePokemonPageLocal.savePage(any(), any())
        }
    }
}