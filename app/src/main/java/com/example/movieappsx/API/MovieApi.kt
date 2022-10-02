package com.example.movieappsx.API

import com.example.movieappsx.Data.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("top_rated?")
    fun getTopRatedMovies(@Query("api_key") api_key: String, @Query("page") page: Int): Call<Movies>
}
