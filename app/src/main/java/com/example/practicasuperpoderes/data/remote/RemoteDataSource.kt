package com.example.practicasuperpoderes.data.remote

import com.example.practicasuperpoderes.domain.model.Comic
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.domain.model.Serie

interface RemoteDataSource {
    suspend fun getHeroes(): List<Hero>
    suspend fun getHero(idHero: String): Hero
    suspend fun getSeries(heroID: String): List<Serie>
    suspend fun getComics(heroID: String): List<Comic>
}
