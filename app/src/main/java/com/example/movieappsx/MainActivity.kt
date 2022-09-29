package com.example.movieappsx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieappsx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val adapter = MovieAdapter()
//        binding.activityMainMoviesRv.adapter = adapter
//        binding.activityMainMoviesRv.layoutManager = GridLayoutManager(applicationContext,2)


    }
}