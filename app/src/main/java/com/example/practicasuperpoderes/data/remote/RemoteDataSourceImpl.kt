package com.example.practicasuperpoderes.data.remote
import com.example.practicasuperpoderes.Secrets
import com.example.practicasuperpoderes.domain.model.Hero
import okhttp3.Credentials
import java.util.Properties
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
/*
        var localProperties = Properties()
        var ts = localProperties.getProperty("TS", "0")
        var hash = localProperties.getProperty("HASH", "xxxxxxxxx")
        var apikey = localProperties.getProperty("APIKEY", "xxxxxxxxx")
*/

        var secrets = Secrets()
        var ts = secrets.ts
        var hash = secrets.hash
        var apikey = secrets.apikey
        var hola =  api.getHeroes(ts, apikey, hash)
        return hola.data.results
    }
}