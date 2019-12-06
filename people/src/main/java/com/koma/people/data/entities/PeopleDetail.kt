package com.koma.people.data.entities

import com.google.gson.annotations.SerializedName

data class PeopleDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("deathday")
    val deathDay: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("biography")
    val biography: String,
    @SerializedName("profile_path")
    val profileUrl: String?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("place_of_birth")
    val placeOfBirth: String?
)
