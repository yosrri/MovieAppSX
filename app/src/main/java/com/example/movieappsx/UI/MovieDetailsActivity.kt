package com.example.movieappsx.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.movieappsx.Data.Movie
import com.example.movieappsx.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var movie: Movie
    private lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movie = intent.getParcelableExtra("movie")!!
        Log.d("SecondActivity", movie.title)
//        binding.movieDetailsIv.setImageResource(movie.posterPath)
        Glide.with(binding.root)
            .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .into(binding.movieDetailsIv)
        binding.movieDetailsTitleTv.text = movie.title
        binding.movieDetailsOverViewTv.text = movie.overview


    }
}