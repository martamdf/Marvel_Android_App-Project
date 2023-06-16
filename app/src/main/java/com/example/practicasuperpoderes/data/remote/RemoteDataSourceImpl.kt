package com.example.practicasuperpoderes.data.remote
import com.example.practicasuperpoderes.domain.model.Hero
import okhttp3.Credentials
import com.example.practicasuperpoderes.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(private val api: MarvelApi) : RemoteDataSource {

    private lateinit var token: String
    override suspend fun login(user: String, password: String): String {
        val token = api.login(Credentials.basic(user, password))
        this.token = token
        return token
    }

    override suspend fun getHeroes(): List<Hero> {

        var ts = BuildConfig.TS
        var hash = BuildConfig.HASH
        var apikey = BuildConfig.APIKEY

        return api.getHeroes(ts, apikey, hash).data.results
    }

    override suspend fun getHero(heroID: String): Hero {
        var ts = BuildConfig.TS
        var hash = BuildConfig.HASH
        var apikey = BuildConfig.APIKEY

        return api.getHero(heroID, ts, apikey, hash).data.results[0]
    }
}