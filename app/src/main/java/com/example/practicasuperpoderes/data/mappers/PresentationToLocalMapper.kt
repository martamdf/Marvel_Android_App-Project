package com.example.practicasuperpoderes.data.mappers

import com.example.practicasuperpoderes.data.local.model.LocalSuperhero
import com.example.practicasuperpoderes.domain.model.UIHero
import javax.inject.Inject

class PresentationToLocalMapper @Inject constructor() {
    fun mapPresentationSuperhero(superHero: UIHero): LocalSuperhero {
        return LocalSuperhero(superHero.id, superHero.name, superHero.description, superHero.thumbnail, superHero.favorite)
    }
}