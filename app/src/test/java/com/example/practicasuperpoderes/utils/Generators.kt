package com.example.practicasuperpoderes.utils

import com.example.practicasuperpoderes.data.local.model.LocalSuperhero
import com.example.practicasuperpoderes.domain.model.Hero
import com.example.practicasuperpoderes.domain.model.Serie
import com.example.practicasuperpoderes.domain.model.Thumbnail
import com.example.practicasuperpoderes.domain.model.UIHero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun generateGetHeroesResponse(size: Int): List<Hero> {
    return (0 until size).map { Hero(it, "Name $it", "Description $it", Thumbnail("photo","extension")) }
}

fun generateLocalSuperheroes(): Flow<List<LocalSuperhero>> {
    return flow {
       emit(listOf(LocalSuperhero("id", "Name", "description", "photo",false)))
    }
}
fun generateOneLocalSuperhero(): LocalSuperhero {
    return LocalSuperhero("1", "Name", "photo", "", false)
}

fun generateUISuperheroes(): Flow<List<UIHero>> {
    return flow {
        emit(listOf(UIHero("1", "Name", "photo", "photo", false)))
    }
}

fun generateOneSuperhero(): Hero {
    return Hero(1, "Name", "photo", Thumbnail("path", "extension"))
}

// Series & Comics
fun generatePublishList(): List<Serie> {
    return listOf(Serie("1","title", Thumbnail("path", "extension")))
}
