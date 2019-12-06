package com.koma.film.data.source

import com.koma.film.data.entities.Film
import io.reactivex.Single

interface Repository {
    fun getPopularFilms(page: Int = 1): Single<List<Film>>
    fun getTopRatedFilms(page: Int = 1): Single<List<Film>>
    fun getNowPlayingFilms(page: Int = 1): Single<List<Film>>
    fun getUpcomingFilms(page: Int = 1): Single<List<Film>>
    fun getSimilarFilms(filmId: Int): Single<List<Film>>
    fun getRecommendedFilms(filmId: Int): Single<List<Film>>
}
