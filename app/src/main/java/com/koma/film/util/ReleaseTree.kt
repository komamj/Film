package com.koma.film.util

import android.util.Log
import androidx.annotation.NonNull
import com.tencent.bugly.crashreport.CrashReport
import timber.log.Timber

class ReleaseTree : Timber.DebugTree() {
    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return priority == Log.WARN || priority == Log.INFO || priority == Log.ERROR ||
                priority == Log.ASSERT
    }

    override fun log(priority: Int, tag: String?, @NonNull message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        if (t != null) {
            CrashReport.postCatchedException(t)
        }
    }
}
