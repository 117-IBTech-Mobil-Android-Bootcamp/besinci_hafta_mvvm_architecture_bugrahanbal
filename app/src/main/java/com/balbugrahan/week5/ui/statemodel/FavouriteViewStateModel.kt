package com.balbugrahan.week5.ui.statemodel

import com.balbugrahan.week5.model.FavouriteMovieModel
import com.balbugrahan.week5.response.FavouriteResponse

class FavouriteViewStateModel(private val favouriteMovieResponse: FavouriteResponse) {
    fun getFavouriteMovies():MutableList<FavouriteMovieModel>{

        val favList = mutableListOf<FavouriteMovieModel>()

        favouriteMovieResponse.favouriteMovie.forEach {
            val favouriteMovie = FavouriteMovieModel(it.key,it.value as String)
            favList.add(favouriteMovie)
        }
        return favList
    }
}