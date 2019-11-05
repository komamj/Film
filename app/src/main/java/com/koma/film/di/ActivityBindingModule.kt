package com.koma.film.di

import com.koma.film.main.MainActivity
import com.koma.film.main.MainModule
import com.koma.film.splash.SplashActivity
import com.koma.film.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun contributeSplashActivity(): SplashActivity
}