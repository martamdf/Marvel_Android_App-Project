package com.example.practicasuperpoderes.ui.superherodetail
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.ui.superherolist.MyBottomBar
import com.example.practicasuperpoderes.ui.superherolist.MyTopBar
import com.example.practicasuperpoderes.ui.superherolist.SuperHeroListScreenContent
import com.example.practicasuperpoderes.ui.superherolist.SuperHeroListViewModel
import com.example.practicasuperpoderes.ui.superherolist.SuperheroItem


@Composable
fun SuperheroDetailScreen(id: String = "1011334", viewModel: SuperheroDetailViewModel)
{
    val state by viewModel.state.collectAsState()
    Log.d("viewModel", "detail")
    LaunchedEffect(Unit){
        viewModel.getSuperhero(id)
    }

   SuperHeroDetailScreenContent(state) { hero ->

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroDetailScreenContent(hero: Hero, onSuperHeroListClicked: (String) -> Unit) {

    val scaffoldS = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopBar()
        },
        bottomBar = {
            MyBottomBar()
        }
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)){
            Text(text = hero.name)
        }
    }
}