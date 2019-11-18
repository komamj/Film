package com.koma.film.people

import com.koma.film.base.BaseViewModelTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PeopleViewModelTest : BaseViewModelTest<PeopleViewModel>() {
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
