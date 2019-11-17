package com.koma.film.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.koma.commonlibrary.base.BaseFragment
import com.koma.film.R
import com.koma.film.databinding.FragmentSplashBinding
import com.koma.film.di.Injectable
import com.koma.film.main.MainActivity
import javax.inject.Inject

class SplashFragment : BaseFragment<FragmentSplashBinding>(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SplashViewModel by viewModels {
        viewModelFactory
    }

    override fun getLayoutId() = R.layout.fragment_splash

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Handler().postDelayed({
            startActivity(Intent(context, MainActivity::class.java))
        }, 1500)
    }
}
