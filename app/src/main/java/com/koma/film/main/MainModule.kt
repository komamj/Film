package com.koma.film.main

import com.koma.film.home.FilmFragment
import com.koma.film.people.PeopleFragment
import com.koma.film.tv.TVShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @ContributesAndroidInjector
    abstract fun contributeFilmFragment(): FilmFragment

    @ContributesAndroidInjector
    abstract fun contributeTVShowFragment(): TVShowFragment

    @ContributesAndroidInjector
    abstract fun contributePeopleFragment(): PeopleFragment
}
