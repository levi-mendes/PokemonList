package com.example.pokemonappagilecontent.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.detail.GetPokemonDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val useCase: GetPokemonDetailUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(PokemonDetailUiState(loading = true))
    val uiState: StateFlow<PokemonDetailUiState> = _uiState.asStateFlow()

    fun getPokemonDetailByName(name: String) {
        viewModelScope.launch {

            runCatching {
                useCase.getPokemonDetail(name)

            }.onSuccess { pokemonDetail ->

                _uiState.update {
                    it.copy(loading = false, pokemonDetail = pokemonDetail)
                }

            }.onFailure {error ->
                _uiState.update {
                    it.copy(loading = false, error = error)
                }
            }
        }
    }
}