package com.example.practicasuperpoderes.data.remote
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.BuildConfig
import com.example.practicasuperpoderes.domain.model.Serie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(private val api: MarvelApi) : RemoteDataSource {

    override suspend fun getHeroes(): List<Hero> {
        return api.getHeroes(BuildConfig.TS, BuildConfig.APIKEY, BuildConfig.HASH).data.results
    }

    override suspend fun getHero(heroID: String): Hero {
        return api.getHero(heroID, BuildConfig.TS, BuildConfig.APIKEY, BuildConfig.HASH).data.results[0]
    }

    override suspend fun getSeries(heroID: String): List<Serie>{
        return api.getSeries(heroID, BuildConfig.TS, BuildConfig.APIKEY, BuildConfig.HASH).data.results
    }

    override suspend fun getComics(heroID: String): List<Serie> {
        return api.getComics(heroID, BuildConfig.TS, BuildConfig.APIKEY, BuildConfig.HASH).data.results
    }
}