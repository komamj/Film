package com.koma.film.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.koma.film.data.source.FilmRepositoryImp
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class PeopleViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: PeopleViewModel

    private val repository = mock(FilmRepositoryImp::class.java)

    @Before
    fun init() {
        viewModel = PeopleViewModel(repository)
    }

    @Test
    fun `should return true when loadPopularPeople is loading`() {
    }

    @Test
    fun `should return people list when loadPopularPeople successful`() {
    }
}