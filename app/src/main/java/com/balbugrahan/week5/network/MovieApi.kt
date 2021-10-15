package com.balbugrahan.week5.network

import com.balbugrahan.week5.response.MoviesDetailsResponse
import com.balbugrahan.week5.response.PopularMovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("popular")
    fun getPopularMovies(
        @Query("api_key") apikey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<PopularMovieListResponse>

    @GET("{movie_id}")
    fun getDetails(
        @Path("movie_id") id : String,
        @Query("api_key") apikey: String,
        @Query("language") language: String,
    ): Call<MoviesDetailsResponse>

}