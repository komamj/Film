package com.koma.people.data.entities

import com.google.gson.annotations.SerializedName

data class Works(
    @SerializedName("poster_path")
    val imageUrl: String?,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("backdrop_path")
    val backdropUrl: String?,
    @SerializedName("vote_average")
    val voteAverage: String
)