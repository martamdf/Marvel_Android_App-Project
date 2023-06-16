package com.example.practicasuperpoderes.data

import com.example.practicasuperpoderes.data.remote.RemoteDataSource
import com.example.practicasuperpoderes.domain.model.Hero
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : Repository {

//    override suspend fun login(user: String, password: String): String {
//        return remoteDataSource.login(user, password)
//    }

    override suspend fun getHeroes(): List<Hero> {
        return remoteDataSource.getHeroes()
    }
    override suspend fun getHero(heroID: String): Hero {
        return remoteDataSource.getHero(heroID)
    }
}