package com.koma.film.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.koma.film.data.entities.Film
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FilmDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: FilmDatabase

    private lateinit var filmDao: FilmDao

    @Before
    fun createDb() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FilmDatabase::class.java
        ).build()

        filmDao = database.filmData()
    }

    @Test
    fun should_return_empty_list_when_getFilms_without_inserted_data() {
        val result = filmDao.getFilms(1)

        assertThat(result).isNotNull()
        assertThat(result).isEmpty()
    }

    @Test
    fun should_return_film_list_when_getFilms_with_inserting_film_list() {
        filmDao.insert(
            Film(100, "", "", "", "", "", "", 1)
        )

        val result = filmDao.getFilms(1)

        assertThat(result).isNotNull()
        assertThat(result).isNotEmpty()
        assertThat(result.size).isEqualTo(1)
        assertThat(result[0].id).isEqualTo(100)
        assertThat(result[0].page).isEqualTo(1)
    }

    @Test
    fun should_return_empty_list_when_getFilms_with_deleteAll_called() {
        should_return_film_list_when_getFilms_with_inserting_film_list()
        filmDao.deleteAll()

        val newResult = filmDao.getFilms(1)

        assertThat(newResult).isNotNull()
        assertThat(newResult).isEmpty()
    }

    @After
    fun closeDb() {
        database.close()
    }
}
