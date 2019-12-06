package com.koma.commonlibrary.base

import android.os.StrictMode
import dagger.android.support.DaggerApplication
import leakcanary.AppWatcher

abstract class BaseApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()

        enableStrictMode()

        AppWatcher.config = AppWatcher.config.copy(watchFragmentViews = true)
    }

    private fun enableStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectNetwork()
                .penaltyLog()
                .penaltyDeath()
                .build()
        )
    }
}