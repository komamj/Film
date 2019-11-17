/*
 * Copyright 2019 JUN MAO
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.koma.film.data.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "people")
data class People(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val avatarUrl: String,
    @SerializedName("known_for")
    val works: List<Works>

) {
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
}
