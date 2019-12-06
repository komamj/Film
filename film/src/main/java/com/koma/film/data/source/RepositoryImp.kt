package com.koma.film.data.source

import com.koma.film.data.entities.Film
import com.koma.film.data.source.remote.WebService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImp @Inject constructor(private val webService: WebService) : Repository {
    override fun getPopularFilms(page: Int): Single<List<Film>> {
        return webService.getPopularFilms(page = page)
            .map {
                it.data
            }
    }

    override fun getTopRatedFilms(page: Int): Single<List<Film>> {
        return webService.getTopRatedFilms(page = page)
            .map {
                it.data
            }
    }

    override fun getNowPlayingFilms(page: Int): Single<List<Film>> {
        return webService.getNowPlayingFilms(page = page)
            .map {
                it.data
            }
    }

    override fun getUpcomingFilms(page: Int): Single<List<Film>> {
        return webService.getUpcomingFilms(page = page)
            .map {
                it.data
            }
    }

    override fun getSimilarFilms(filmId: Int): Single<List<Film>> {
        return webService.getSimilarFilms(filmId)
            .map {
                it.data
            }
    }

    override fun getRecommendedFilms(filmId: Int): Single<List<Film>> {
        return webService.getRecommendedFilms(filmId)
            .map {
                it.data
            }
    }
}
