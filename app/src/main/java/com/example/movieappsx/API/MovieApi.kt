package com.example.movieappsx.API

import com.example.movieappsx.Data.PagesMeta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("top_rated?")
   suspend fun getTopRatedMovies(@Query("api_key") api_key: String, @Query("page") page: Int): Response<PagesMeta>
    /*fun getTopRatedMovies(@Query("api_key") api_key: String, @Query("page") page: Int): Call<Movies>*/
}
