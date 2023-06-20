package com.example.practicasuperpoderes.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.collectAsState
import com.example.practicasuperpoderes.data.Repository
import com.example.practicasuperpoderes.ui.superherolist.SuperHeroListViewModel
import com.example.practicasuperpoderes.utils.generateLocalSuperheroes
import com.example.practicasuperpoderes.utils.generateOneSuperhero
import com.example.practicasuperpoderes.utils.generateUISuperheroes
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SuperHeroViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // UUT o SUT
    private lateinit var viewModel: SuperHeroListViewModel

    // Mocks
    private lateinit var repository: Repository
    // Fakes

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        repository = mockk()
        viewModel = SuperHeroListViewModel(repository)
    }

    @Test
    fun `WHEN getHero EXPECT successful response`()  {
        // GIVEN

        val id = "testingID"
        coEvery { repository.getHeroes() } returns generateUISuperheroes()

        // WHEN
        val actual = viewModel.getSuperheros()
        val actualLiveData = viewModel.state.value

        // THEN
        assertEquals(actualLiveData.size, 1)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}