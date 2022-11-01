package com.example.movieappsx

import com.example.movieappsx.Data.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappsx.API.APIClient
import kotlinx.coroutines.*

const val APIKEY = "1b762faba77bb606900c43f155b37bbe"
const val PAGENUMBER = 2

class MovieViewModel : ViewModel() {

    private var movieLiveData = MutableLiveData<List<Movie>>()

        fun getTopRatedMovies(){
            viewModelScope.launch(Dispatchers.IO) {
            val response = APIClient.getRetrofit().getTopRatedMovies(APIKEY, PAGENUMBER)
                if(response.isSuccessful) movieLiveData.postValue(response.body()?.details)
            }
        }
    
    fun observeMovieLiveData(): LiveData<List<Movie>> {
        return movieLiveData
    }
}