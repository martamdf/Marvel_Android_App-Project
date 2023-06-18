package com.example.practicasuperpoderes.ui.superherodetail
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.domain.model.Serie
import com.example.practicasuperpoderes.domain.model.Thumbnail
import com.example.practicasuperpoderes.domain.model.UIHero


@Composable
fun SuperheroDetailScreen(id: String, viewModel: SuperheroDetailViewModel, onClick:()-> Unit = {})
{
    val state by viewModel.state.collectAsState()
    val seriesState by viewModel.stateSeries.collectAsState()
    val comicsState by viewModel.stateComics.collectAsState()

    LaunchedEffect(Unit){
        viewModel.getSuperhero(id)
        viewModel.getSeries(id)
        viewModel.getComics(id)
    }

   SuperHeroDetailScreenContent(state, seriesState, comicsState) {
       onClick()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroDetailScreenContent(hero: UIHero, series: List<Serie>, comics:List<Serie>, goBack:() -> Unit) {

    //val scaffoldS = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopBarDetail(hero.name){
                goBack()
            }
        },
    ) { contentPadding ->
        HeroDetalle(hero, series, comics, modifier = Modifier.padding(contentPadding))
    }
}

@Composable
fun HeroDetalle(hero: UIHero, series: List<Serie>, comics: List<Serie>, modifier: Modifier){
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item{
            HeroInfo(hero = hero)
        }
        item{
            Text(text = "Series", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(8.dp))
        }
        item{
            SerieList(series)
        }

        item{
          Text(text = "Comics", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(8.dp))
        }

        item{
            SerieList(comics)
        }
    }
}

@Composable
fun HeroInfo(hero: UIHero){
    Column(
        modifier = Modifier
            .padding()
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        AsyncImage(
            model = hero.thumbnail,
            contentDescription = "${hero.name} photo",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(text = hero.name, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(8.dp))
        Text(text = hero.description, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun SerieList(series: List<Serie>){
    LazyRow(Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(series,
            key = { it.id }) { serie ->
            SerieItem(serie = serie)
        }
    }
}

@Composable
fun SerieItem(serie: Serie, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .width(200.dp)
            .height(300.dp)
    ) {
        AsyncImage(
            model = serie.thumbnail.path + "."+ serie.thumbnail.extension,
            contentDescription = "${serie.title} photo",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentScale = ContentScale.Crop
        )
        Text(text = serie.title, style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun MyTopBarDetail(name: String, goBack:() -> Unit = {}){
    TopAppBar(
        title = {
            androidx.compose.material.Text(text = name)
        },
        navigationIcon = {
            IconButton(onClick = { goBack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        }
    )
}

@Preview
@Composable
fun MyTopBarDetail_Preview() {
    MyTopBarDetail("Nombre Heroe", {})
}

@Preview
@Composable
fun MySerieItem_Preview() {
    SerieItem(serie = Serie("1", "Título Serie", Thumbnail("","")))
}
