package com.balbugrahan.week5.ui.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.balbugrahan.week5.repository.RepositoryMovie
import com.balbugrahan.week5.ui.statemodel.MovieListViewStateModel
import com.balbugrahan.week5.utils.API_KEY

class MovieListViewModel : ViewModel() {

    val moviesResponse = MediatorLiveData<MovieListViewStateModel>()
    val movieRepository = RepositoryMovie()
    var page = 1

    init {
        movieRepository.getAllMovies(API_KEY,page)

        moviesResponse.addSource(movieRepository.onMoviesFetched) {
            moviesResponse.value = MovieListViewStateModel(it) }
    }
    fun getMoviesWithPagination(){
        movieRepository.getAllMovies(API_KEY,++page)
    }
}