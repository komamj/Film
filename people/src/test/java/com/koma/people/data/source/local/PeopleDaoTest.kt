package com.koma.people.data.source.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.koma.people.data.entities.People
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class PeopleDaoTest {
    private lateinit var database: PeopleDatabase

    private lateinit var peopleDao: PeopleDao

    @Before
    fun `create db`() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PeopleDatabase::class.java
        ).allowMainThreadQueries().build()

        peopleDao = database.peopleDao()
    }

    @Test
    fun `should return empty list when getPeople without inserted data`() {
        val result = peopleDao.getPeople(pageId = 1)

        assertThat(result).isNotNull()
        assertThat(result).isEmpty()
    }

    @Test
    fun `should return people list when getPeople with inserted data`() {
        peopleDao.insert(People(0, "koma", "", 1))

        val result = peopleDao.getPeople(1)

        assertThat(result).isNotEmpty()
        assertThat(result.size).isEqualTo(1)
        assertThat(result[0].name).isEqualTo("koma")
    }

    @After
    fun `close db`() {
        database.close()
    }
}