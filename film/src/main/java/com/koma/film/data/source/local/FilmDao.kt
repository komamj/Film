package com.koma.film.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.koma.film.data.entities.Film

@Dao
interface FilmDao {
    @Query("SELECT * from film where page_id = :pageId")
    fun getFilms(pageId: Int): List<Film>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(film: Film)

    @Query("DELETE FROM film")
    fun deleteAll()
}
