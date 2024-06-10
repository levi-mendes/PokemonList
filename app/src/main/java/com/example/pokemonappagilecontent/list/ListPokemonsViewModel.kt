package com.example.pokemonappagilecontent.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.list.ListPokemonPageLocalUseCase
import com.example.core.list.ListPokemonPageUseCase
import com.example.core.list.SavePokemonPageLocalUseCase
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

    private var nextPage: Int = 0

    init {
        loadNextPokemonPage()
    }

    fun loadNextPokemonPage() {
        _uiState.update {
            it.copy(loading = true)
        }

        viewModelScope.launch {
            val initialIndex = if (_uiState.value.currentItensCount > 0) _uiState.value.currentItensCount + 1 else 0

            runCatching {
                var pokemons = getPokemonPageLocal.listPokemonPage(nextPage)

                if (pokemons.isEmpty()) {
                    pokemons = getPokemonPage.listPokemonPage(initialIndex, 150)
                    savePokemonPageLocal.savePage(nextPage, pokemons)
                }

                nextPage++
                pokemons

            }.onSuccess { pokemons ->
                val updatedIndex = initialIndex + pokemons.lastIndex
                val updatedList = uiState.value.pokemons
                updatedList?.addAll(pokemons)
                updatedList?.sortBy { it.name }
                Log.e("pokemons", updatedList.toString())

                _uiState.update {
                    it.copy(
                        loading = false,
                        isNewResultSearch = true,
                        pokemons = updatedList,
                        currentItensCount = updatedIndex
                    )
                }

            }.onFailure {error ->
                _uiState.update {
                    it.copy(loading = false, error = error)
                }
            }
        }
    }
}