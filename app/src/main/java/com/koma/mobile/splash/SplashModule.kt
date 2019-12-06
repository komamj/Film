package com.koma.mobile.splash

import androidx.lifecycle.ViewModel
import com.koma.commonlibrary.di.FragmentScoped
import com.koma.commonlibrary.di.ViewModelKey
import com.koma.commonlibrary.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SplashModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeSplashFragment(): SplashFragment

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel
}
