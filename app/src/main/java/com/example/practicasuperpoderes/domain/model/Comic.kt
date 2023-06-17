package com.example.practicasuperpoderes.domain.model

data class ResponseComic(
    val code: Int,
    val data: DataComic
)

data class DataComic(
    val offset: Int,
    val results: List<Comic>
)

data class Comic(
    val id:String,
    val title: String,
    val thumbnail: Thumbnail
)
