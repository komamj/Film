package com.koma.people.data.source

import com.koma.people.data.entities.People
import com.koma.people.data.entities.PeopleDetail
import com.koma.people.data.source.remote.WebService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImp @Inject constructor(private val webService: WebService) : Repository {
    override fun getPopularPeople(page: Int): Single<List<People>> {
        return webService.getPopularPeople(page = page)
            .map {
                it.data
            }
    }

    override fun getPeopleDetail(peopleId: Int): Single<PeopleDetail> {
        return webService.getPeopleDetail(peopleId)
    }
}
