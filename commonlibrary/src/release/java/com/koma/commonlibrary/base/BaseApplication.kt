package com.koma.commonlibrary.base

import android.app.Application
import com.koma.commonlibrary.util.ReleaseTree
import timber.log.Timber

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(ReleaseTree())
    }
}