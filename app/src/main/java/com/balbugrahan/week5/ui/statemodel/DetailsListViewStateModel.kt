package com.balbugrahan.week5.ui.statemodel

import com.balbugrahan.week5.response.MoviesDetailsResponse

class DetailsListViewStateModel(val moviesResponse: MoviesDetailsResponse) {

    fun getId(): Int = moviesResponse.id
    fun getTitle(): String = moviesResponse.title
    fun getVoteCount(): Int = moviesResponse.vote_count
    fun getVoteAverage(): Number = moviesResponse.vote_average
    fun getReleaseDate(): String = moviesResponse.release_date
    fun getOverview(): String = moviesResponse.overview
    fun getPoster(): String = moviesResponse.poster_path
    fun getPopularity(): Number = moviesResponse.popularity
    fun getRuntime(): String {
        val movieHour: Int = moviesResponse.movietime / 60
        val movieMin: Int = moviesResponse.movietime % 60
        return "${movieHour}h ${movieMin}min"
    }

    fun getAdult(): String {
        return if (moviesResponse.adult) {
            "PG-18"
        } else {
            "PG-13"
        }
    }


}