package com.example.pokemonappagilecontent.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.list.ListPokemonPageLocalUseCase
import com.example.core.list.ListPokemonPageUseCase
import com.example.core.list.SavePokemonPageLocalUseCase
import com.example.pokemonappagilecontent.exception.InternetConnectionException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListPokemonsViewModel(
    private val getPokemonPage: ListPokemonPageUseCase,
    private val getPokemonPageLocal: ListPokemonPageLocalUseCase,
    private val savePokemonPageLocal: SavePokemonPageLocalUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow(ListPokemonsUiState(loading = true))
    val uiState: StateFlow<ListPokemonsUiState> = _uiState.asStateFlow()

    var nextPage: Int = 0

    fun loadNextPokemonPage() {
        _uiState.update { it.copy(loading = true) }

        viewModelScope.launch {
            runCatching {
                var pokemons = getPokemonPageLocal.listPokemonPage(nextPage)

                if (pokemons.isEmpty()) {
                    val initialIndex = _uiState.value.pokemons.size
                    pokemons = getPokemonPage.listPokemonPage(initialIndex)
                    savePokemonPageLocal.savePage(nextPage, pokemons)
                }

                nextPage++
                pokemons

            }.onSuccess { pokemons ->
                uiState.value.pokemons.addAll(pokemons)
                val sortedList = uiState.value.pokemons.sortedBy { it.name}.toMutableList()

                _uiState.update {
                    it.copy(loading = false, pokemons =  sortedList, error = null)
                }

            }.onFailure { error ->
                _uiState.update {
                    it.copy(loading = false, error = InternetConnectionException())
                }
            }
        }
    }
}