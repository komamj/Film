package com.koma.film.home

import com.koma.film.base.BaseViewModelTest
import com.koma.film.data.entities.Film
import com.koma.film.util.LiveDataTestUtil
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`

@RunWith(JUnit4::class)
class FilmViewModelTest : BaseViewModelTest<FilmViewModel>() {
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
