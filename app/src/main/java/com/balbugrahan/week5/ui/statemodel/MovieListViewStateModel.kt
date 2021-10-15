package com.balbugrahan.week5.ui.statemodel

import com.balbugrahan.week5.model.Movie
import com.balbugrahan.week5.response.PopularMovieListResponse

data class MovieListViewStateModel (val moviesResponse: PopularMovieListResponse){
    fun getList() : List<Movie> = moviesResponse.movies }