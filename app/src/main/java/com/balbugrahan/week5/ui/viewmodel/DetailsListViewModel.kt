package com.balbugrahan.week5.ui.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.balbugrahan.week5.repository.RepositoryMovie
import com.balbugrahan.week5.ui.statemodel.DetailsListViewStateModel

class DetailsListViewModel(id:String) : ViewModel() {

    val moviesDetailsResponse = MediatorLiveData<DetailsListViewStateModel>()
    val movieDetailsRepository = RepositoryMovie()

    init {
        movieDetailsRepository.getDetailsOfMovies(id)
        moviesDetailsResponse.addSource(movieDetailsRepository.onMoviesDetailsFetched) {
        moviesDetailsResponse.value = DetailsListViewStateModel(it) }
    }
}