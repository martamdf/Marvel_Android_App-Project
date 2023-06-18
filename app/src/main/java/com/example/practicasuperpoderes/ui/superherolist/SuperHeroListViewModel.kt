package com.example.practicasuperpoderes.ui.superherolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicasuperpoderes.data.Repository
import com.example.practicasuperpoderes.domain.model.UIHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SuperHeroListViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _state = MutableStateFlow<List<UIHero>>(emptyList())
    val state: StateFlow<List<UIHero>> get() = _state

    fun getSuperheros() {
        viewModelScope.launch {
            repository.getHeroes().collect { heroes ->
                _state.value = heroes
            }
        }
    }
    fun insertSuperhero(hero: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateHero(hero)
        }
    }
}