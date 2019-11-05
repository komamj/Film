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

package com.koma.film.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.koma.commonlibrary.base.BaseViewModel
import com.koma.commonlibrary.testing.OpenForTesting
import com.koma.film.data.entities.People
import com.koma.film.data.source.FilmRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@OpenForTesting
class PeopleViewModel @Inject constructor(
    private val repository: FilmRepository
) : BaseViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _people = MutableLiveData<List<People>>()
    val people: MutableLiveData<List<People>>
        get() = _people

    fun loadPopularPeople() {
        _isLoading.value = true
        val disposable = repository.getPopularPeople(page = 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _isLoading.value = false
                    _people.value = it
                },
                {
                    _isLoading.value = false
                }
            )
        addSubscription(disposable)
    }
}