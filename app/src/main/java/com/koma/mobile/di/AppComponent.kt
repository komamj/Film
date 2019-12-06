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

package com.koma.mobile.di

import android.app.Application
import com.koma.commonlibrary.di.AppModule
import com.koma.film.FilmModule
import com.koma.film.data.source.RepositoryModule
import com.koma.mobile.FilmApp
import com.koma.mobile.splash.SplashModule
import com.koma.people.PeopleModule
import com.koma.tv.TVModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        SplashModule::class,
        FilmModule::class,
        TVModule::class,
        PeopleModule::class,
        RepositoryModule::class,
        com.koma.people.data.source.RepositoryModule::class,
        com.koma.tv.data.source.RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<FilmApp> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
