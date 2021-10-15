package com.balbugrahan.week5.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import com.balbugrahan.week5.repository.RepositoryMovie
import com.balbugrahan.week5.ui.statemodel.FavouriteViewStateModel

class FavouriteViewModel(application: Application): AndroidViewModel(application) {

    val favResponse = MediatorLiveData<FavouriteViewStateModel>()
    private val favRepository = RepositoryMovie()

    init {
        favRepository.getFavouriteMovies(application)
        favResponse.addSource(favRepository.onFavMoviesFetched){
            favResponse.value = FavouriteViewStateModel(it) }
    }
    fun moviesRepeat(){
        favRepository.getFavouriteMovies(this.getApplication())
    }
}