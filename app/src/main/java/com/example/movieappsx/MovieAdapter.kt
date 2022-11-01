package com.example.movieappsx


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappsx.Data.Movie
import com.example.movieappsx.databinding.MovieLayoutBinding


class MovieAdapter(private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movieList = ArrayList<Movie>()
    inner class ViewHolder(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    class OnClickListener(val clickListener: (Movie) -> Unit = {}) {
        fun onClick(movie: Movie) = this.clickListener(movie)
    }

    fun setMovieList(movieList: ArrayList<Movie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MovieLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        setMovieCover(holder, movie)
        setMovieTitle(holder, movie)
        showMovieDetails(holder, movie)
    }

    private fun setMovieTitle(holder: ViewHolder, movie: Movie) =
        holder.binding.activityMainMovieNameRvTv.apply {
            this.text = movie.title
        }

    private fun setMovieCover(holder: ViewHolder, movie: Movie) =
        Glide.with(holder.binding.root)
            .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .into(holder.binding.activityMainMoviesRvIv)

    private fun showMovieDetails(holder: ViewHolder, movie: Movie) =
        holder.itemView.setOnClickListener {
            onClickListener.onClick(mo
                    vie)
        }

    override fun getItemCount(): Int {
        return movieList.size
    }

}