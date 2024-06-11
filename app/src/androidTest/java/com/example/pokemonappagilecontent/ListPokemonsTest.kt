package com.example.pokemonappagilecontent

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.pokemonappagilecontent.list.ListPokemons
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

class ListPokemonsTest {

    @get:Rule
    val composeTestRule = createComposeRule()
//    private val getPokemonPage: ListPokemonPageUseCase = mockk()
//    private val getPokemonPageLocal: ListPokemonPageLocalUseCase = mockk()
//    private val savePokemonPageLocal: SavePokemonPageLocalUseCase = mockk()

//    private lateinit var listPokemonsViewModel: ListPokemonsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
//    @Before
//    fun before() {
        //Dispatchers.setMain(Dispatchers.Main)
//        listPokemonsViewModel = ListPokemonsViewModel(
//            getPokemonPage, getPokemonPageLocal, savePokemonPageLocal
//        )
//    }

    @Test
    fun shouldCallDetailScrennAfterItemClick() {
        composeTestRule.setContent {
            ListPokemons(onItemClick = {})
        }

        Thread.sleep(3000)
        composeTestRule.onNodeWithText("alakazam").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Details").assertIsDisplayed()
    }

    @Test
    fun should_List_Show_150_items() {
        composeTestRule.setContent {
            ListPokemons(onItemClick = {})
        }

        Thread.sleep(2000)

        composeTestRule.onNodeWithTag(testTag = "POKEMON_LIST")
            .onChildren()
            .assertCountEquals(150)
    }

    @Test
    fun shouldShowInternetErrorMessageWhenNotConnected() {
        composeTestRule.setContent {
            ListPokemons(onItemClick = {})
        }

        composeTestRule.onNodeWithText("Please, check your internet connection and try again !!!").assertIsDisplayed()
    }
}