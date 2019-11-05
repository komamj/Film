package com.koma.commonlibrary.base

import android.app.Application
import android.os.StrictMode
import com.koma.commonlibrary.util.DebugTree
import leakcanary.AppWatcher
import timber.log.Timber

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        enableStrictMode()

        AppWatcher.config = AppWatcher.config.copy(watchFragmentViews = true)

        Timber.plant(DebugTree())
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