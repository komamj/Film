package com.koma.film.data.source

import com.koma.commonlibrary.testing.OpenForTesting
import com.koma.film.data.entities.Film
import com.koma.film.data.entities.People
import com.koma.film.data.entities.PeopleDetail
import com.koma.film.data.entities.TVShow
import com.koma.film.data.source.remote.WebService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@OpenForTesting
@Singleton
class FilmRepositoryImp @Inject constructor(private val webService: WebService) : FilmRepository {
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

    override fun getPopularPeople(page: Int): Single<List<People>> {
        return webService.getPopularPeople(page = page)
            .map {
                it.data
            }
    }

    override fun getPeopleDetail(peopleId: Int): Single<PeopleDetail> {
        return webService.getPeopleDetail(peopleId)
    }

    override fun getPopularTV(page: Int): Single<List<TVShow>> {
        return webService.getPopularTV(page = page)
            .map {
                it.data
            }
    }

    override fun getTopRatedTV(page: Int): Single<List<TVShow>> {
        return webService.getTopRatedTV(page = page)
            .map {
                it.data
            }
    }

    override fun getOnTV(page: Int): Single<List<TVShow>> {
        return webService.getOnTV(page = page)
            .map {
                it.data
            }
    }

    override fun getAiringTodayTV(page: Int): Single<List<TVShow>> {
        return webService.getAiringTodayTV(page = page)
            .map {
                it.data
            }
    }
}