package com.koma.tv

import androidx.lifecycle.ViewModel
import com.koma.commonlibrary.di.ViewModelKey
import com.koma.commonlibrary.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class TVModule {
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeTVShowFragment(): TVShowFragment

    @Binds
    @IntoMap
    @ViewModelKey(TVShowViewModel::class)
    abstract fun bindTVShowViewModel(viewModel: TVShowViewModel): ViewModel
}
