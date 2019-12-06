package com.koma.tv.data.source

import com.koma.tv.data.entities.TVShow
import io.reactivex.Single

interface Repository {
    fun getPopularTV(page: Int): Single<List<TVShow>>
    fun getTopRatedTV(page: Int): Single<List<TVShow>>
    fun getOnTV(page: Int): Single<List<TVShow>>
    fun getAiringTodayTV(page: Int): Single<List<TVShow>>
}
