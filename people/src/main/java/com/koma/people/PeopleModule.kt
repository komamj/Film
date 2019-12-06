package com.koma.people

import androidx.lifecycle.ViewModel
import com.koma.commonlibrary.di.FragmentScoped
import com.koma.commonlibrary.di.ViewModelKey
import com.koma.commonlibrary.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class PeopleModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributePeopleFragment(): PeopleFragment

    @Binds
    @IntoMap
    @ViewModelKey(PeopleViewModel::class)
    abstract fun bindPeopleViewModel(viewModel: PeopleViewModel): ViewModel
}
