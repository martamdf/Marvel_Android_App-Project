package com.example.practicasuperpoderes.data

import com.example.practicasuperpoderes.domain.model.Hero

interface Repository {
    //suspend fun login(user: String, password: String): String
    suspend fun getHeroes(): List<Hero>
    suspend fun getHero(heroID: String): Hero
}
