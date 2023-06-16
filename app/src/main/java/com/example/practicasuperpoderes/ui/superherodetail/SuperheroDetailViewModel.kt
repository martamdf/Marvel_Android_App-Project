package com.example.practicasuperpoderes.ui.superherodetail
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicasuperpoderes.data.Repository
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.domain.model.Serie
import com.example.practicasuperpoderes.domain.model.Thumbnail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class SuperheroDetailViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val hero = Hero(1,"","", Thumbnail("",""))

    private val _state = MutableStateFlow<Hero>(hero)
    val state: StateFlow<Hero> get() = _state

    private val _stateSeries = MutableStateFlow<List<Serie>>(emptyList())
    val stateSeries: StateFlow<List<Serie>> get() = _stateSeries

    fun getSuperhero(heroID: String) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.getHero(heroID)
            }

            _state.update { result }
        }
    }

    fun getSeries(heroID: String) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.getSeries(heroID)
            }

            _stateSeries.update { result }
        }
    }
}