package com.koma.film

import androidx.lifecycle.ViewModel
import com.koma.commonlibrary.di.ViewModelKey
import com.koma.commonlibrary.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FilmModule {
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeFilmCategoryFragment(): FilmCategoryFragment

    @Binds
    @IntoMap
    @ViewModelKey(FilmViewModel::class)
    abstract fun bindFilmViewModel(viewModel: FilmViewModel): ViewModel
}
