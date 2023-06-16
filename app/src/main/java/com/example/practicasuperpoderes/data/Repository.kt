package com.example.practicasuperpoderes.data

import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.domain.model.Serie

interface Repository {
    suspend fun getHeroes(): List<Hero>
    suspend fun getHero(heroID: String): Hero
    suspend fun getSeries(heroID: String): List<Serie>
}
