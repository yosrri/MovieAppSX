package com.example.movieappsx

import com.example.movieappsx.Data.Details
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappsx.API.APIClient
import com.example.movieappsx.Data.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val APIKEY = "1b762faba77bb606900c43f155b37bbe"

class MovieViewModel : ViewModel() {

    private var movieLiveData = MutableLiveData<List<Details>>()


    fun getTopRatedMovies() {
        APIClient.getClient().apply {
            getTopRatedMovies(APIKEY, 2).enqueue(object : Callback<Movies> {
                override fun onResponse(call: Call<Movies>?, response: Response<Movies>?) {
                    response?.body()?.let {
                        Log.d("TAG", response.code().toString() + "what is that")
                        movieLiveData.value = response.body().details
                    }
                }

                override fun onFailure(call: Call<Movies>?, t: Throwable?) {
                    t?.let { Log.d("TAG", t.message.toString()) }
                }
            })
        }
    }

    fun observeMovieLiveData(): LiveData<List<Details>> {
        return movieLiveData
    }
}