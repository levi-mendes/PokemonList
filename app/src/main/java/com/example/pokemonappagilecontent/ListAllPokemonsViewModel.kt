package com.example.pokemonappagilecontent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.ListPokemonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListAllPokemonsViewModel(
    private val listAll: ListPokemonUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(ListAllPokemonsUiState(loading = true))
    val uiState: StateFlow<ListAllPokemonsUiState> = _uiState.asStateFlow()

    init {
        loadPokemonPage()
    }

    fun loadPokemonPage() {
        viewModelScope.launch {
            val initialIndex = _uiState.value.currentItensCount

            runCatching {
                listAll.listPokemonPage(initialIndex, 150)

            }.onSuccess { allPokemons ->
                val updatedIndex = initialIndex + allPokemons.lastIndex

                _uiState.update {
                    it.copy(loading = false, pokemons = allPokemons, currentItensCount = updatedIndex)
                }

            }.onFailure {error ->
                _uiState.update {
                    it.copy(loading = false, error = error)
                }
            }
        }
    }
}