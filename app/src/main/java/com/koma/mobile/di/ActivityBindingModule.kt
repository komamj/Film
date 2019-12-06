package com.koma.mobile.di

import com.koma.commonlibrary.di.ActivityScoped
import com.koma.film.FilmModule
import com.koma.mobile.main.MainActivity
import com.koma.mobile.splash.SplashActivity
import com.koma.mobile.splash.SplashModule
import com.koma.people.PeopleModule
import com.koma.tv.TVModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            FilmModule::class,
            TVModule::class,
            PeopleModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun contributeSplashActivity(): SplashActivity
}
