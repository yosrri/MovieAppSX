package com.example.movieappsx.Data

import com.google.gson.annotations.SerializedName

data class PagesMeta(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val details: List<Movie>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int
)