package com.koma.film.splash

import android.os.Bundle
import androidx.fragment.app.commit
import com.koma.commonlibrary.base.BaseActivity
import com.koma.film.R
import com.koma.film.databinding.ActivitySplashBinding
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding>(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        val splashFragment = supportFragmentManager.findFragmentById(R.id.content_main)
                as SplashFragment? ?: SplashFragment().also {
            supportFragmentManager.commit {
                replace(R.id.content_main, it)
            }
        }
    }

    override fun getLayoutId() = R.layout.activity_splash

    override fun androidInjector() = dispatchingAndroidInjector
}
