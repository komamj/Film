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

package com.koma.film.data.source.remote

import com.koma.film.data.entities.DataModel
import com.koma.film.data.entities.Film
import com.koma.film.data.entities.People
import com.koma.film.data.entities.PeopleDetail
import com.koma.film.data.entities.TVShow
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {
    @GET("movie/popular")
    fun getPopularFilms(@Query("page") page: Int = 1): Single<DataModel<Film>>

    @GET("movie/top_rated")
    fun getTopRatedFilms(@Query("page") page: Int = 1): Single<DataModel<Film>>

    @GET("movie/now_playing")
    fun getNowPlayingFilms(@Query("page") page: Int = 1): Single<DataModel<Film>>

    @GET("movie/upcoming")
    fun getUpcomingFilms(@Query("page") page: Int = 1): Single<DataModel<Film>>

    /**
     * Get a list of similar movies
     */
    @GET("movie/{movie_id}/similar")
    fun getSimilarFilms(@Path("movie_id") movieId: Int): Single<DataModel<Film>>

    /**
     * Get a list of recommended movies for a movie.
     */
    @GET("movie/{movie_id}/recommendations")
    fun getRecommendedFilms(@Path("movie_id") movieId: Int): Single<DataModel<Film>>

    @GET("movie/{movie_id}/images")
    fun getImages(@Path("movie_id") movieId: Int)

    @POST("movie/{movie_id}/rating")
    fun postRatingFilm(@Path("movie_id") movieId: Int)

    @GET("search/movie")
    fun searchFilms(
        @Query("keyword") keyword: String,
        @Query("include_adult") includeAdult: Boolean = true
    ): Single<DataModel<Film>>

    /**
     * People api
     */
    @GET("person/popular")
    fun getPopularPeople(@Query("page") page: Int): Single<DataModel<People>>

    @GET("person/{person_id}")
    fun getPeopleDetail(@Path("person_id") personId: Int): Single<PeopleDetail>

    /**
     * TV api
     */
    @GET("tv/popular")
    fun getPopularTV(@Query("page") page: Int): Single<DataModel<TVShow>>

    @GET("tv/top_rated")
    fun getTopRatedTV(@Query("page") page: Int): Single<DataModel<TVShow>>

    @GET("tv/on_the_air")
    fun getOnTV(@Query("page") page: Int): Single<DataModel<TVShow>>

    @GET("tv/airing_today")
    fun getAiringTodayTV(@Query("page") page: Int): Single<DataModel<TVShow>>
}
