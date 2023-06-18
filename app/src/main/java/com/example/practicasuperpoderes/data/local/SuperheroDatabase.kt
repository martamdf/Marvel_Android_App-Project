package com.example.practicasuperpoderes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practicasuperpoderes.data.local.model.LocalSuperhero

class SuperHeroDataBase {
    @Database(entities = [LocalSuperhero::class], version = 1)
    abstract class SuperheroDatabase : RoomDatabase() {
        abstract fun superheroDao(): SuperheroDAO
    }
}