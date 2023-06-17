package com.example.practicasuperpoderes.data

import com.example.practicasuperpoderes.data.remote.RemoteDataSource
//import com.example.practicasuperpoderes.domain.model.Comic
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.domain.model.Serie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : Repository {

    override suspend fun getHeroes(): List<Hero> {
        return remoteDataSource.getHeroes()
    }
    override suspend fun getHero(heroID: String): Hero {
        return remoteDataSource.getHero(heroID)
    }
    override suspend fun getSeries(heroID: String): List<Serie> {
        return remoteDataSource.getSeries(heroID)
    }
    override suspend fun getComics(heroID: String): List<Serie> {
        return remoteDataSource.getComics(heroID)
    }
}