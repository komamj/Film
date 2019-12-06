package com.koma.tv

import com.koma.tv.data.entities.TVShow
import com.koma.tv.data.source.Repository
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    private val repository = mock(Repository::class.java)

    private val testScheduler = TestScheduler()

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

        // assertThat(LiveDataTestUtil.getValue(viewModel.isLoading)).isTrue()
        testScheduler.triggerActions()
        //  assertThat(LiveDataTestUtil.getValue(viewModel.isLoading)).isFalse()
    }

    @Test
    fun `should return TVShows list when loadTVShows successful`() {
    }
}
