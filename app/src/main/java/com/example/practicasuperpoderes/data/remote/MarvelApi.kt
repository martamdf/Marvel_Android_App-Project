package com.example.practicasuperpoderes.data.remote

import com.example.practicasuperpoderes.data.remote.request.GetHeroesRequest
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.domain.model.Response
import com.example.practicasuperpoderes.domain.model.ResponseSerie
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {
    @GET("v1/public/characters")
    suspend fun getHeroes(@Query("ts") ts: String, @Query("apikey") apiKey: String,  @Query("hash") hash: String): Response//List<Hero>
    @GET("v1/public/characters/{id}")
    suspend fun getHero(@Path("id") heroId: String, @Query("ts") ts: String, @Query("apikey") apiKey: String, @Query("hash") hash: String): Response
    @GET("v1/public/characters/{id}/series")
    suspend fun getSeries(@Path("id") heroId: String, @Query("ts") ts: String, @Query("apikey") apiKey: String, @Query("hash") hash: String): ResponseSerie

}
