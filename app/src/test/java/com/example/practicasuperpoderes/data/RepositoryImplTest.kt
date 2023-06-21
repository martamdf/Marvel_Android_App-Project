package com.example.practicasuperpoderes.data

import com.example.practicasuperpoderes.data.local.LocalDataSource
import com.example.practicasuperpoderes.data.local.fakes.FakeLocalDataSource
import com.example.practicasuperpoderes.data.mappers.LocalToPresentationMapper
import com.example.practicasuperpoderes.data.mappers.PresentationToLocalMapper
import com.example.practicasuperpoderes.data.mappers.RemoteToLocalMapper
import com.example.practicasuperpoderes.data.remote.RemoteDataSource
import com.example.practicasuperpoderes.data.remote.fakes.FakeRemoteDataSource
import com.example.practicasuperpoderes.utils.generateOneLocalSuperhero
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class RepositoryImplTest {
    // SUT
    private lateinit var repositoryImpl: RepositoryImpl

    // Dependencies
    private lateinit var localDataSource: LocalDataSource
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var remoteToLocalMapper: RemoteToLocalMapper
    private lateinit var localToPresentationMapper: LocalToPresentationMapper
    private lateinit var presentationToLocalMapper: PresentationToLocalMapper

    @Before
    fun setup() {
        remoteToLocalMapper = RemoteToLocalMapper()
        localToPresentationMapper = LocalToPresentationMapper()
        presentationToLocalMapper = PresentationToLocalMapper()
    }

    // Test con Fakes
    @Test
    fun `WHEN getHeroes EXPECT local empty, return not empty list and match with the list build with generateLocalSuperheroes fun`() = runTest {
        // GIVEN
        localDataSource = FakeLocalDataSource()
        remoteDataSource = FakeRemoteDataSource()
        repositoryImpl =
            RepositoryImpl(remoteDataSource, localDataSource, remoteToLocalMapper, localToPresentationMapper, presentationToLocalMapper)

        // WHEN
        val actual = repositoryImpl.getHeroes().toList()

        // THEN
        assert(actual.first().isNotEmpty())
        assert(actual.first()[0].thumbnail== "photo")
    }

    // Test con Mocks
    @Test
    fun `WHEN getHero EXPECT one Hero`() = runTest {
        // GIVEN
        localDataSource = mockk()
        remoteDataSource = mockk()
        repositoryImpl =
            RepositoryImpl(remoteDataSource, localDataSource, remoteToLocalMapper, localToPresentationMapper, presentationToLocalMapper)

        coEvery { localDataSource.getHero("1") } returns generateOneLocalSuperhero()

        // WHEN
        val actual = repositoryImpl.getHero("1") // cambia a true

        // THEN
        assert(!actual.favorite)
    }
}