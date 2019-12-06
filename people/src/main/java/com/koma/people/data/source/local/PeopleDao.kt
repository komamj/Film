package com.koma.people.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.koma.people.data.entities.People

@Dao
interface PeopleDao {
    @Query("SELECT * from people where page_id = :pageId")
    fun getPeople(pageId: Int): List<People>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: People)

    @Query("DELETE FROM people")
    fun deleteAll()
}