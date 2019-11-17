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

package com.koma.film.data.source

import com.koma.film.data.entities.Film
import com.koma.film.data.entities.People
import com.koma.film.data.entities.PeopleDetail
import com.koma.film.data.entities.TVShow
import io.reactivex.Single

interface FilmRepository {
    fun getPopularFilms(page: Int = 1): Single<List<Film>>
    fun getTopRatedFilms(page: Int = 1): Single<List<Film>>
    fun getNowPlayingFilms(page: Int = 1): Single<List<Film>>
    fun getUpcomingFilms(page: Int = 1): Single<List<Film>>
    fun getSimilarFilms(filmId: Int): Single<List<Film>>
    fun getRecommendedFilms(filmId: Int): Single<List<Film>>
    fun getPopularPeople(page: Int): Single<List<People>>
    fun getPeopleDetail(peopleId: Int): Single<PeopleDetail>
    fun getPopularTV(page: Int): Single<List<TVShow>>
    fun getTopRatedTV(page: Int): Single<List<TVShow>>
    fun getOnTV(page: Int): Single<List<TVShow>>
    fun getAiringTodayTV(page: Int): Single<List<TVShow>>
}
