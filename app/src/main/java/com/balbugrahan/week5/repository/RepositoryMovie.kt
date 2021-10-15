package com.balbugrahan.week5.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.balbugrahan.week5.network.BaseCallBack
import com.balbugrahan.week5.response.MoviesDetailsResponse
import com.balbugrahan.week5.response.PopularMovieListResponse
import com.balbugrahan.week5.network.ServiceConnector
import com.balbugrahan.week5.response.FavouriteResponse
import com.balbugrahan.week5.utils.API_KEY

class RepositoryMovie {

    val onMoviesFetched = MutableLiveData<PopularMovieListResponse>()
    val onMoviesDetailsFetched = MutableLiveData<MoviesDetailsResponse>()
    val onFavMoviesFetched = MutableLiveData<FavouriteResponse>()

    fun getAllMovies(apikey: String, page: Int) {
        ServiceConnector.restInterface.getPopularMovies(apikey, "en-US", page)
            .enqueue(object : BaseCallBack<PopularMovieListResponse>() {
                override fun onSuccess(data: PopularMovieListResponse) {
                    onMoviesFetched.postValue(data)
                }
            })
    }
    fun getDetailsOfMovies(id: String) {
        ServiceConnector.restInterface.getDetails(id, API_KEY, "en-US")
            .enqueue(object : BaseCallBack<MoviesDetailsResponse>() {
                override fun onSuccess(data: MoviesDetailsResponse) {
                    onMoviesDetailsFetched.postValue(data)
                } })
    }
    fun getFavouriteMovies(context: Context) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("Shared", Context.MODE_PRIVATE)
        val list = FavouriteResponse(sharedPreferences.all)
        onFavMoviesFetched.value = list
    }
}