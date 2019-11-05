package com.koma.film.splash

import androidx.lifecycle.ViewModel
import com.koma.commonlibrary.testing.OpenForTesting
import com.koma.film.data.source.FilmRepository
import javax.inject.Inject

@OpenForTesting
class SplashViewModel @Inject constructor(private val repository: FilmRepository) : ViewModel() {
}