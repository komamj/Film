package com.koma.mobile

import com.koma.commonlibrary.base.BaseApplication
import com.koma.mobile.di.DaggerAppComponent
import com.koma.mobile.util.DebugTree
import com.koma.mobile.util.ProcessUtils
import com.koma.mobile.util.ReleaseTree
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.bugly.crashreport.CrashReport.UserStrategy
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject
import timber.log.Timber

class FilmApp : BaseApplication() {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        initCrashReport()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    private fun initCrashReport() {
        val processName = ProcessUtils.getProcessName(android.os.Process.myPid())
        val strategy = UserStrategy(this)
        strategy.isUploadProcess = processName == null || processName == packageName
        CrashReport.initCrashReport(this, BuildConfig.BUGLY_APP_ID, false, strategy)
    }

    override fun androidInjector() = dispatchingAndroidInjector
}
