package com.koma.people.data.source.remote

import com.koma.commonlibrary.data.entities.DataModel
import com.koma.people.data.entities.People
import com.koma.people.data.entities.PeopleDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {
    /**
     * People api
     */
    @GET("person/popular")
    fun getPopularPeople(@Query("page") page: Int): Single<DataModel<People>>

    @GET("person/{person_id}")
    fun getPeopleDetail(@Path("person_id") personId: Int): Single<PeopleDetail>
}
