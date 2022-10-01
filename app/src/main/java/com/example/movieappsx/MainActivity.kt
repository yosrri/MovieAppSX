package com.example.movieappsx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappsx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //didnt work cause i didnt do the get request
        val adapter = MovieAdapter()
        val res = Result("mesh3arf","thor")
        val res1 = Result("mesh3arf","thor")
        val res2 = Result("mesh3arf","thor")
        var movieList = arrayListOf<Result>(res,res2,res1)
        adapter.setMovieList(movieList)
        binding.activityMainMoviesRv.adapter = adapter
        binding.activityMainMoviesRv.layoutManager = GridLayoutManager(this,2)
    }
}