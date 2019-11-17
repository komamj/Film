/*
 * Copyright 2019 JUN MAO
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.koma.film.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.koma.commonlibrary.base.BaseViewModel
import com.koma.commonlibrary.testing.OpenForTesting
import com.koma.film.data.entities.Film
import com.koma.film.data.source.FilmRepositoryImp
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@OpenForTesting
class FilmViewModel @Inject constructor(
    private val repository: FilmRepositoryImp
) : BaseViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _films = MutableLiveData<List<Film>>()
    val films: LiveData<List<Film>>
        get() = _films

    fun loadFilms(category: Int) {
        _isLoading.value = true
        val disposable = getFilmsByCategory(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _isLoading.value = false
                    _films.value = it
                },
                {
                    _isLoading.value = false
                })
        addSubscription(disposable)
    }

    private fun getFilmsByCategory(category: Int): Single<List<Film>> {
        return when (category) {
            0 -> {
                repository.getPopularFilms(page = 1)
            }
            1 -> {
                repository.getTopRatedFilms(page = 1)
            }
            2 -> {
                repository.getUpcomingFilms(page = 1)
            }
            3 -> {
                repository.getNowPlayingFilms(page = 1)
            }
            else -> {
                repository.getPopularFilms(page = 1)
            }
        }
    }
}
