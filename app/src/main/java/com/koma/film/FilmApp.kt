package com.koma.film

import com.koma.commonlibrary.base.BaseApplication
import com.koma.film.di.AppInjector
import com.koma.film.util.DebugTree
import com.koma.film.util.ProcessUtils
import com.koma.film.util.ReleaseTree
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.bugly.crashreport.CrashReport.UserStrategy
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import timber.log.Timber

class FilmApp : BaseApplication(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        AppInjector.inject(this)

        initCrashReport()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    private fun initCrashReport() {
        val processName = ProcessUtils.getProcessName(android.os.Process.myPid())
        val strategy = UserStrategy(this)
        strategy.isUploadProcess = processName == null || processName == packageName
        CrashReport.initCrashReport(this, BuildConfig.BUGLY_APP_ID, false, strategy)
    }

    override fun androidInjector() = dispatchingAndroidInjector
}
