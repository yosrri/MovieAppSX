package com.example.movieappsx

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("top_rated?")
    fun getTopRatedMovies(@Query ("api_key") api_key :String) : Call<Movies>
}
