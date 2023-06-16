package com.example.practicasuperpoderes.domain.model


data class ResponseSerie(
    val code: Int,
    val data: DataSerie
)

data class DataSerie(
    val offset: Int,
    val results: List<Serie>
)

data class Serie(
    val id:String,
    val title: String,
    val photo: Thumbnail
)
