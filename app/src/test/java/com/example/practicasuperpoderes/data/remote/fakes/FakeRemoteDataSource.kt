package com.example.practicasuperpoderes.data.remote.fakes

import com.example.practicasuperpoderes.data.remote.RemoteDataSource
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.domain.model.Serie
import com.example.practicasuperpoderes.utils.generateGetHeroesResponse
import com.example.practicasuperpoderes.utils.generateOneSuperhero
import com.example.practicasuperpoderes.utils.generatePublishList

class FakeRemoteDataSource: RemoteDataSource {

    override suspend fun getHeroes():  List<Hero> {
        return generateGetHeroesResponse(15)
    }

    override suspend fun getHero(idHero: String): Hero {
        return generateOneSuperhero()
    }

    override suspend fun getSeries(heroID: String): List<Serie> {
        return generatePublishList()
    }

    override suspend fun getComics(heroID: String): List<Serie> {
        return generatePublishList()
    }
}