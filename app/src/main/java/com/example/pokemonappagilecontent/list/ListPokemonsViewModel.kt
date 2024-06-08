package com.example.pokemonappagilecontent.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.ListPokemonPageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListPokemonsViewModel(
    private val getPokemonPage: ListPokemonPageUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(ListPokemonsUiState(loading = true))
    val uiState: StateFlow<ListPokemonsUiState> = _uiState.asStateFlow()

    private var nextPage: Int = 0

    init {
        loadNextPokemonPage()
    }

    fun loadNextPokemonPage() {
        viewModelScope.launch {
            val initialIndex = _uiState.value.currentItensCount

            runCatching {
                getPokemonPage.listPokemonPage(initialIndex, 20)

            }.onSuccess { allPokemons ->
                val updatedIndex = initialIndex + allPokemons.lastIndex
                uiState.value.pokemons?.addAll(allPokemons)

                _uiState.update {
                    it.copy(loading = false, pokemons = uiState.value.pokemons, currentItensCount = updatedIndex)
                }

            }.onFailure {error ->
                _uiState.update {
                    it.copy(loading = false, error = error)
                }
            }
        }
    }
}