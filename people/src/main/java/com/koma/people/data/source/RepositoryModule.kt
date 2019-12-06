package com.koma.people.data.source

import android.app.Application
import androidx.room.Room
import com.koma.people.data.source.local.PeopleDao
import com.koma.people.data.source.local.PeopleDatabase
import com.koma.people.data.source.remote.WebService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideDatabase(application: Application): PeopleDatabase {
        return Room.databaseBuilder(
            application,
            PeopleDatabase::class.java, "people_database"
        ).build()
    }

    @Singleton
    @Provides
    fun providePeopleDao(database: PeopleDatabase): PeopleDao {
        return database.peopleDao()
    }

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
