package com.koma.people.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "people")
data class People(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "avatar_url")
    @SerializedName("profile_path")
    val avatarUrl: String,
    @ColumnInfo(name = "page_id")
    val page: Int
) {
    @Ignore
    @SerializedName("known_for")
    val works = mutableListOf<Works>()
}
