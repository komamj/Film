package com.koma.film.splash

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SplashModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment
}