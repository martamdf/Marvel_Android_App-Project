package com.example.practicasuperpoderes.data

import com.example.practicasuperpoderes.domain.model.Hero

interface Repository {
    //suspend fun login(user: String, password: String): String
    suspend fun getHeros(): List<Hero>
}
