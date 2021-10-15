package com.balbugrahan.week5.network

import com.balbugrahan.week5.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceConnector {
    companion object{
        private var retrofit : Retrofit? =null
        lateinit var restInterface : MovieApi

        fun init() {
            val logging = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY) }
            val httpClient: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
            restInterface = retrofit?.create(MovieApi::class.java)!! } }
}