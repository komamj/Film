package com.koma.film.tv

import com.koma.film.base.BaseViewModelTest
import com.koma.film.data.entities.TVShow
import com.koma.film.util.LiveDataTestUtil
import io.reactivex.Single
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyInt

@RunWith(JUnit4::class)
class TVShowViewModelTest : BaseViewModelTest<TVShowViewModel>() {
    @Before
    fun init() {
        viewModel = TVShowViewModel(repository)
    }

    @Test
    fun `should return true when loadTVShows is loading`() {
        `when`(repository.getPopularTV(anyInt()))
            .thenReturn(
                Single.just(emptyList<TVShow>()).subscribeOn(testScheduler)
            )

        viewModel.loadTVShows(0)

        assertTrue(LiveDataTestUtil.getValue(viewModel.isLoading))
        testScheduler.triggerActions()
        assertFalse(LiveDataTestUtil.getValue(viewModel.isLoading))
    }

    @Test
    fun `should return TVShows list when loadTVShows successful`() {
    }
}
