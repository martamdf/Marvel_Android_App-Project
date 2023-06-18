package com.example.practicasuperpoderes.data

import android.util.Log
import com.example.practicasuperpoderes.data.local.LocalDataSource
import com.example.practicasuperpoderes.data.mappers.LocalToPresentationMapper
import com.example.practicasuperpoderes.data.mappers.RemoteToLocalMapper
import com.example.practicasuperpoderes.data.remote.RemoteDataSource
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.domain.model.Serie
import com.example.practicasuperpoderes.domain.model.UIHero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val remoteToLocalMapper: RemoteToLocalMapper,
    private val localToPresentationMapper: LocalToPresentationMapper
) : Repository {

    override suspend fun getHeroes(): Flow<List<UIHero>> {
        if (localDataSource.dbIsEmpty()) {
            val remoteSuperheros = remoteDataSource.getHeroes()
            localDataSource.insertHeroes(remoteToLocalMapper.mapGetHeroesResponse(remoteSuperheros))
        }
        return localDataSource.getHeroes().map {
            localToPresentationMapper.mapLocalSuperheroes(it)
        }
    }
    override suspend fun getHero(heroID: String): UIHero {
        return localToPresentationMapper.mapLocalSuperhero(localDataSource.getHero(heroID))
    }
    override suspend fun getSeries(heroID: String): List<Serie> {
        return remoteDataSource.getSeries(heroID)
    }
    override suspend fun getComics(heroID: String): List<Serie> {
        return remoteDataSource.getComics(heroID)
    }
}