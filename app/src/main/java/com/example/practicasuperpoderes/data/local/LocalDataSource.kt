package com.example.practicasuperpoderes.data.local

import com.example.practicasuperpoderes.data.local.model.LocalSuperhero
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {
    suspend fun getHeroes(): Flow<List<LocalSuperhero>>
    suspend fun insertHeroes(localSuperheros: List<LocalSuperhero>)
    suspend fun dbIsEmpty(): Boolean
    suspend fun getHero(heroID: String): LocalSuperhero
    suspend fun deleteData()
}