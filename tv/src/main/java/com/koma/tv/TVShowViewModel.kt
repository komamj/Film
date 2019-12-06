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

package com.koma.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.koma.commonlibrary.base.BaseViewModel
import com.koma.commonlibrary.testing.OpenForTesting
import com.koma.tv.data.entities.TVShow
import com.koma.tv.data.source.Repository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@OpenForTesting
class TVShowViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _tvShows = MutableLiveData<List<TVShow>>()
    val tvShows: MutableLiveData<List<TVShow>>
        get() = _tvShows

    fun loadTVShows(category: Int) {
        _isLoading.value = true
        val disposable = getTVShowsByCategory(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _isLoading.value = false

                    _tvShows.value = it
                },
                {
                    _isLoading.value = false
                }
            )
        addSubscription(disposable)
    }

    private fun getTVShowsByCategory(category: Int): Single<List<TVShow>> {
        return when (category) {
            0 -> {
                repository.getPopularTV(1)
            }
            1 -> {
                repository.getTopRatedTV(1)
            }
            2 -> {
                repository.getOnTV(1)
            }
            3 -> {
                repository.getAiringTodayTV(1)
            }
            else -> {
                repository.getPopularTV(1)
            }
        }
    }
}
