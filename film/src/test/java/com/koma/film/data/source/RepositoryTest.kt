package com.koma.film.data.source

import com.google.common.truth.Truth.assertThat
import com.koma.commonlibrary.data.entities.DataModel
import com.koma.film.data.entities.Film
import com.koma.film.data.source.remote.WebService
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class RepositoryTest {
    private val webService = Mockito.mock(WebService::class.java)

    private lateinit var repository: Repository

    @Before
    fun init() {
        repository = RepositoryImp(webService)
    }

    @Test
    fun `should return films list when getPopularFilms successful`() {
        Mockito.`when`(webService.getPopularFilms(1)).thenReturn(
            Single.just(
                buildDataModelWithFilm()
            )
        )

        val testObserver = repository.getPopularFilms(page = 1).test()

        testObserver.assertValueCount(1)
        testObserver.assertNoErrors()
        testObserver.assertValue {
            assertThat(it).isNotEmpty()
            assertThat(it[0].id).isEqualTo(100)
            assertThat(it[1].id).isEqualTo(101)
            assertThat(it[2].id).isEqualTo(102)
            assertThat(it[3].id).isEqualTo(103)
            it.size == 4
        }
        testObserver.dispose()
    }

    @Test
    fun `should return network error when getPopularFilms when network disconnected`() {
        Mockito.`when`(webService.getPopularFilms(1)).thenReturn(
            Single.error {
                Throwable("network error")
            }
        )

        val testObserver = repository.getPopularFilms(page = 1).test()

        testObserver.assertErrorMessage("network error")
        testObserver.dispose()
    }

    companion object {
        private fun buildDataModelWithFilm(): DataModel<Film> {
            return DataModel(
                1, listOf(
                    Film(100, "", "", "", "", "", "", 1),
                    Film(101, "", "", "", "", "", "", 1),
                    Film(102, "", "", "", "", "", "", 1),
                    Film(103, "", "", "", "", "", "", 1)
                )
            )
        }

        /*private fun buildDataModelWithPeople(): DataModel<People> {
            return DataModel(
                1, listOf(
                    People(100, "", "", emptyList()),
                    People(101, "", "", emptyList()),
                    People(102, "", "", emptyList()),
                    People(103, "", "", emptyList())
                )
            )
        }

        private fun buildDataModelWithTvShow(): DataModel<TVShow> {
            return DataModel(
                1, listOf(
                    TVShow(100, "", "", "", "", "", ""),
                    TVShow(101, "", "", "", "", "", ""),
                    TVShow(102, "", "", "", "", "", ""),
                    TVShow(103, "", "", "", "", "", "")
                )
            )
        }*/
    }
}
