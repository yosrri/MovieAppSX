package com.example.movieappsx.Data

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val details: List<Details>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int
)