package com.koma.tv.data.source.remote

import com.koma.commonlibrary.data.entities.DataModel
import com.koma.tv.data.entities.TVShow
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    /**
     * TV api
     */
    @GET("tv/popular")
    fun getPopularTV(@Query("page") page: Int): Single<DataModel<TVShow>>

    @GET("tv/top_rated")
    fun getTopRatedTV(@Query("page") page: Int): Single<DataModel<TVShow>>

    @GET("tv/on_the_air")
    fun getOnTV(@Query("page") page: Int): Single<DataModel<TVShow>>

    @GET("tv/airing_today")
    fun getAiringTodayTV(@Query("page") page: Int): Single<DataModel<TVShow>>
}
