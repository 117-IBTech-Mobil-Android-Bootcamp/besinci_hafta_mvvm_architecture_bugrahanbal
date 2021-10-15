package com.balbugrahan.week5.response

data class MoviesDetailsResponse (
    val id:Int,
    val title:String,
    val vote_average:Number,
    val vote_count:Int,
    val release_date:String,
    val overview:String,
    val poster_path:String,
    val popularity:Number,
    val movietime:Int,
    val adult:Boolean
)