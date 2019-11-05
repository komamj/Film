package com.koma.film

import com.koma.commonlibrary.base.BaseApplication
import com.koma.film.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class FilmApp : BaseApplication(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        AppInjector.inject(this)
    }

    override fun androidInjector() = dispatchingAndroidInjector
}