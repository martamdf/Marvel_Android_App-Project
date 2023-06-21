package com.example.practicasuperpoderes

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.example.practicasuperpoderes.domain.model.Serie
import com.example.practicasuperpoderes.domain.model.Thumbnail
import com.example.practicasuperpoderes.domain.model.UIHero
import com.example.practicasuperpoderes.ui.superherodetail.SuperHeroDetailScreenContent
import org.junit.Rule
import org.junit.Test

class SuperheroDetailScreenContentTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun given_a_not_fav_hero_its_heart_is_correctly_displayed(){
        // GIVEN
        val hero = UIHero("", "", "", "", false)
        composeRule.setContent {
            SuperHeroDetailScreenContent(hero=hero,
                listOf(Serie("", "", Thumbnail("", ""))),
                listOf(Serie("", "", Thumbnail("", ""))),
                goBack = {},
                onSuperHeroFavClicked = {})
        }

        // THEN
        composeRule.onNodeWithContentDescription("Is not Favorite").assertIsDisplayed()
    }
}