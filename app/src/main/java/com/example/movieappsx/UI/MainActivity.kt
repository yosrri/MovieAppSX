package com.example.movieappsx.UI

import com.example.movieappsx.Data.Details
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieappsx.MovieAdapter
import com.example.movieappsx.MovieViewModel
import com.example.movieappsx.databinding.ActivityMainBinding
import com.example.movieappsx.databinding.MovieLayoutBinding

const val COLUMNS = 2

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getTopRatedMovies()
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList as ArrayList<Details>)
        })
    }

    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter(MovieAdapter.OnClickListener { details ->
            Toast.makeText(applicationContext, details.title, Toast.LENGTH_SHORT).show()
        })
        binding.activityMainMoviesRv.apply {
            layoutManager = GridLayoutManager(applicationContext, COLUMNS)
            adapter = movieAdapter
        }
    }

}