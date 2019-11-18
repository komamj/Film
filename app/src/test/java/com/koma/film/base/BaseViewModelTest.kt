package com.koma.film.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.koma.commonlibrary.base.BaseViewModel
import com.koma.film.data.source.FilmRepositoryImp
import com.koma.film.util.RxJavaRule
import io.reactivex.schedulers.TestScheduler
import org.junit.Rule
import org.mockito.Mockito.mock

open class BaseViewModelTest<T : BaseViewModel> {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Rule
    @JvmField
    val rxJavaRule = RxJavaRule()

    protected val testScheduler = TestScheduler()

    protected lateinit var viewModel: T

    protected val repository = mock(FilmRepositoryImp::class.java)
}
