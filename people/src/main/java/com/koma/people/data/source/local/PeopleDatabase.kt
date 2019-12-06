package com.koma.people.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.koma.people.data.entities.People

@Database(
    version = 1,
    entities = [People::class],
    exportSchema = true
)
abstract class PeopleDatabase : RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
}