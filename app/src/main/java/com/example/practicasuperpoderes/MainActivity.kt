package com.example.practicasuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicasuperpoderes.ui.navigation.NavigationGraph
import com.example.practicasuperpoderes.ui.superherodetail.SuperheroDetailViewModel
import com.example.practicasuperpoderes.ui.superherolist.SuperHeroListViewModel
import com.example.practicasuperpoderes.ui.theme.PracticaSuperPoderesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val superHeroListViewModel: SuperHeroListViewModel by viewModels()
    private val superHeroDetailViewModel: SuperheroDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaSuperPoderesTheme {
                NavigationGraph(superHeroListViewModel, superHeroDetailViewModel)
            }
        }
    }
}
