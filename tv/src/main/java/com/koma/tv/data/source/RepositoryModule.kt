package com.koma.tv.data.source

import com.koma.tv.data.source.remote.WebService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(repository: RepositoryImp): Repository {
        return repository
    }
}
