package com.example.practicasuperpoderes.di

import com.example.practicasuperpoderes.data.Repository
import com.example.practicasuperpoderes.data.RepositoryImpl
import com.example.practicasuperpoderes.data.remote.RemoteDataSource
import com.example.practicasuperpoderes.data.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(defaultRepository: RepositoryImpl): Repository

    @Binds
    abstract fun bindRemoteDataSource(defaultRemoteDataSource: RemoteDataSourceImpl): RemoteDataSource
}