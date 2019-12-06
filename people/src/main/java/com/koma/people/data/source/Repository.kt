package com.koma.people.data.source

import com.koma.people.data.entities.People
import com.koma.people.data.entities.PeopleDetail
import io.reactivex.Single

interface Repository {
    fun getPopularPeople(page: Int): Single<List<People>>
    fun getPeopleDetail(peopleId: Int): Single<PeopleDetail>
}
