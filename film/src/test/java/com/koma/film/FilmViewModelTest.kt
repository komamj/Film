package com.koma.film

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.koma.film.data.entities.Film
import com.koma.film.data.source.Repository
import com.koma.sharedtest.util.LiveDataTestUtil.getValue
import com.koma.sharedtest.util.RxJavaRule
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class FilmViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val rxJavaRule = RxJavaRule()

    private val repository = mock(Repository::class.java)

    private val testScheduler = TestScheduler()

    private lateinit var viewModel: FilmViewModel

    @Before
    fun init() {
        viewModel = FilmViewModel(repository)
    }

    @Test
    fun `should return true when loadFilms is loading`() {
        `when`(repository.getPopularFilms(1)).thenReturn(
            Single.just(emptyList<Film>())
                .subscribeOn(testScheduler)
        )

        viewModel.loadFilms(0)

        assertThat(getValue(viewModel.isLoading)).isTrue()
        testScheduler.triggerActions()
        assertThat(getValue(viewModel.isLoading)).isFalse()
    }

    @Test
    fun `should return films list when loadFilms successful`() {
        `when`(repository.getPopularFilms(1)).thenReturn(
            Single.just(
                listOf(
                    Film(123, "", "", "", "", "", "", 1)
                )
            ).subscribeOn(testScheduler)
        )

        viewModel.loadFilms(0)

        assertThat(getValue(viewModel.films)).isNull()
        testScheduler.triggerActions()
        assertThat(getValue(viewModel.films)).isNotNull()
        assertThat(getValue(viewModel.films).size).isEqualTo(1)
    }
}
