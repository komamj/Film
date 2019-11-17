package com.koma.film.data.source

import com.koma.film.data.entities.DataModel
import com.koma.film.data.entities.Film
import com.koma.film.data.source.remote.WebService
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class FilmRepositoryTest {
    private val webService = mock(WebService::class.java)

    private lateinit var repository: FilmRepository

    @Before
    fun init() {
        repository = FilmRepositoryImp(webService)
    }

    @Test
    fun `should return films list when getPopularFilms successful`() {
        `when`(webService.getPopularFilms(1)).thenReturn(
            Single.just(
                DataModel(
                    1, listOf(
                        Film(123, "", "", "", "", "", "")
                    )
                )
            )
        )
        val testObserver = repository.getPopularFilms(page = 1).test()
        testObserver.assertNoErrors()
        testObserver.assertValue {
            it.size == 1
        }
    }

    @Test
    fun getTopRatedFilms() {
    }

    @Test
    fun getNowPlayingFilms() {
    }

    @Test
    fun getUpcomingFilms() {
    }

    @Test
    fun getSimilarFilms() {
    }

    @Test
    fun getRecommendedFilms() {
    }

    @Test
    fun getPopularPeople() {
    }

    @Test
    fun getPeopleDetail() {
    }

    @Test
    fun getPopularTV() {
    }

    @Test
    fun getTopRatedTV() {
    }

    @Test
    fun getOnTV() {
    }

    @Test
    fun getAiringTodayTV() {
    }
}
