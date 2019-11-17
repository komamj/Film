package com.koma.commonlibrary.base

import android.app.Application
import android.os.StrictMode
import leakcanary.AppWatcher

open class BaseApplication : Application() {
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