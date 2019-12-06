package com.koma.film.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.koma.film.data.entities.Film

@Database(
    version = 1,
    entities = [Film::class],
    exportSchema = true
)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmData(): FilmDao
}
