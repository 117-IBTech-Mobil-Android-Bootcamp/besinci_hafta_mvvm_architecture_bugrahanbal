package com.balbugrahan.week5.model

data class Movie(
    val poster_path: String,
    val overwiew: String,
    val release_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val title: String,
    val vote_count: Int,
    val vote_average: Double,
    val popularity: Number
)