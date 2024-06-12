package com.example.pokemonappagilecontent.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.detail.GetPokemonDetailLocalUseCase
import com.example.core.detail.GetPokemonDetailUseCase
import com.example.core.detail.SavePokemonDetailsLocalUseCase
import com.example.pokemonappagilecontent.exception.InternetConnectionException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    private val getPokemonDetailLocalUseCase: GetPokemonDetailLocalUseCase,
    private val savePokemonDetailLocalUseCase: SavePokemonDetailsLocalUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(PokemonDetailUiState(loading = true))
    val uiState: StateFlow<PokemonDetailUiState> = _uiState.asStateFlow()

    fun getPokemonDetailByName(name: String) {
        viewModelScope.launch {

            runCatching {
                var pokemonDetail = getPokemonDetailLocalUseCase.getByName(name)

                if (pokemonDetail == null) {
                    pokemonDetail = getPokemonDetailUseCase.getPokemonDetail(name)
                    savePokemonDetailLocalUseCase.save(pokemonDetail)
                }

                pokemonDetail

            }.onSuccess { pokemonDetail ->
                _uiState.update {
                    it.copy(loading = false, pokemonDetail = pokemonDetail)
                }

            }.onFailure { error ->
                _uiState.update {
                    it.copy(loading = false, error = InternetConnectionException())
                }
            }
        }
    }
}