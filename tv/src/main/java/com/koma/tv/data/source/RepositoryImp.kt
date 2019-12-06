package com.koma.tv.data.source

import com.koma.tv.data.entities.TVShow
import com.koma.tv.data.source.remote.WebService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImp @Inject constructor(private val webService: WebService) : Repository {
    override fun getPopularTV(page: Int): Single<List<TVShow>> {
        return webService.getPopularTV(page = page)
            .map {
                it.data
            }
    }

    override fun getTopRatedTV(page: Int): Single<List<TVShow>> {
        return webService.getTopRatedTV(page = page)
            .map {
                it.data
            }
    }

    override fun getOnTV(page: Int): Single<List<TVShow>> {
        return webService.getOnTV(page = page)
            .map {
                it.data
            }
    }

    override fun getAiringTodayTV(page: Int): Single<List<TVShow>> {
        return webService.getAiringTodayTV(page = page)
            .map {
                it.data
            }
    }
}
