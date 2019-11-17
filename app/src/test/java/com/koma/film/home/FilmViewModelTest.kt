package com.koma.film.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.koma.film.data.entities.Film
import com.koma.film.data.source.FilmRepositoryImp
import com.koma.film.util.LiveDataTestUtil
import com.koma.film.util.RxJavaRule
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class FilmViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Rule
    @JvmField
    val rxJavaRule = RxJavaRule()

    private lateinit var testScheduler: TestScheduler

    private lateinit var viewModel: FilmViewModel

    private val repository = mock(FilmRepositoryImp::class.java)

    @Before
    fun init() {
        testScheduler = TestScheduler()

        viewModel = FilmViewModel(repository)
    }

    @Test
    fun `should return true when loadFilms is loading`() {
        `when`(repository.getPopularFilms(1)).thenReturn(
            Single.just(emptyList<Film>())
                .subscribeOn(testScheduler)
        )
        viewModel.loadFilms(0)
        assertTrue(LiveDataTestUtil.getValue(viewModel.isLoading))
        testScheduler.triggerActions()
        assertFalse(LiveDataTestUtil.getValue(viewModel.isLoading))
    }

    @Test
    fun `should return films list when loadFilms successful`() {
        `when`(repository.getPopularFilms(1)).thenReturn(
            Single.just(
                listOf(
                    Film(123, "", "", "", "", "", "")
                )
            ).subscribeOn(testScheduler)
        )
        viewModel.loadFilms(0)
        assertNull(LiveDataTestUtil.getValue(viewModel.films))
        testScheduler.triggerActions()
        assertNotNull(LiveDataTestUtil.getValue(viewModel.films))
        assertEquals(LiveDataTestUtil.getValue(viewModel.films).size, 1)
    }
}
