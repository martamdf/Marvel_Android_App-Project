package com.example.practicasuperpoderes.data.remote

import com.example.practicasuperpoderes.domain.model.Hero

interface RemoteDataSource {

    suspend fun login(user: String, password: String): String
    suspend fun getHeroes(): List<Hero>
}
