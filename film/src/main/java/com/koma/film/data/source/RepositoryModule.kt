package com.koma.film.data.source

import android.app.Application
import androidx.room.Room
import com.koma.film.data.source.local.FilmDao
import com.koma.film.data.source.local.FilmDatabase
import com.koma.film.data.source.remote.WebService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideDatabase(application: Application): FilmDatabase {
        return Room.databaseBuilder(
            application,
            FilmDatabase::class.java, "film_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideFilmDao(database: FilmDatabase): FilmDao {
        return database.filmData()
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
