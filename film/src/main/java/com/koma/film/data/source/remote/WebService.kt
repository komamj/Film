package com.koma.film.data.source.remote

import com.koma.commonlibrary.data.entities.DataModel
import com.koma.film.data.entities.Film
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
}
