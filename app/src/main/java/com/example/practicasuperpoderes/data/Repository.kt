package com.example.practicasuperpoderes.data

import com.example.practicasuperpoderes.domain.model.Serie
import com.example.practicasuperpoderes.domain.model.UIHero
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getHeroes(): Flow<List<UIHero>>
    suspend fun getHero(heroID: String): UIHero
    suspend fun putHero(heroID: String)
    suspend fun updateHero(heroID: String)
    suspend fun getSeries(heroID: String): List<Serie>
    suspend fun getComics(heroID: String): List<Serie>
}
