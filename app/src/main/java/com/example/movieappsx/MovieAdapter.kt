package com.example.movieappsx

import android.R

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappsx.Data.Details
import com.example.movieappsx.databinding.MovieLayoutBinding


class MovieAdapter(private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movieList = ArrayList<Details>()

    inner class ViewHolder(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    class OnClickListener(val clickListener: (Details) -> Unit = {}) {
        fun onClick(details: Details) = this.clickListener(details)
    }

    fun setMovieList(movieList: ArrayList<Details>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MovieLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.binding.root)
            .load("https://image.tmdb.org/t/p/w500" + movieList[position].posterPath)
            .into(holder.binding.activityMainMoviesRvIv)
        holder.binding.activityMainMovieNameRvTv.text = movieList[position].title

        val details = movieList[position]
        holder.itemView.setOnClickListener {
            onClickListener.onClick(details)
        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}