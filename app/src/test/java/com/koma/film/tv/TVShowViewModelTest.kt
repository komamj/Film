package com.koma.film.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.koma.film.data.source.FilmRepositoryImp
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class TVShowViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TVShowViewModel

    private val repository = mock(FilmRepositoryImp::class.java)

    @Before
    fun init() {
        viewModel = TVShowViewModel(repository)
    }

    @Test
    fun `should return true when loadTVShows is loading`() {

    }

    @Test
    fun `should return TVShows list when loadTVShows successful`() {
    }
}