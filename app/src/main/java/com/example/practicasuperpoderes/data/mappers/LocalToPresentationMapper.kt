package com.example.practicasuperpoderes.data.mappers

import com.example.practicasuperpoderes.data.local.model.LocalSuperhero
import com.example.practicasuperpoderes.domain.model.UIHero
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {
    fun mapLocalSuperheroes(localSuperheroes: List<LocalSuperhero>): List<UIHero> {
        return localSuperheroes.map { mapLocalSuperhero(it) }
    }
    fun mapLocalSuperhero(getHeroesResponse: LocalSuperhero): UIHero {
        return UIHero(getHeroesResponse.id, getHeroesResponse.name,getHeroesResponse.description, getHeroesResponse.photo, getHeroesResponse.favorite)
    }
}