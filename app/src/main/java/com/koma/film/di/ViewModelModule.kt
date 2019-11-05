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

package com.koma.film.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.koma.film.FilmViewModelFactory
import com.koma.film.home.FilmViewModel
import com.koma.film.people.PeopleViewModel
import com.koma.film.splash.SplashViewModel
import com.koma.film.tv.TVShowViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FilmViewModel::class)
    abstract fun bindFilmViewModel(viewModel: FilmViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TVShowViewModel::class)
    abstract fun bindTVShowViewModel(viewModel: TVShowViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PeopleViewModel::class)
    abstract fun bindPeopleViewModel(viewModel: PeopleViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: FilmViewModelFactory): ViewModelProvider.Factory
}