package com.koma.film.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class WebServiceTest {
    private lateinit var webService: WebService

    private lateinit var mockWebServer: MockWebServer

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun `start service`() {
        mockWebServer = MockWebServer()

        webService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(WebService::class.java)
    }

    @Test
    fun `should return fim list when getFilms successful`() {
        assertThat(webService).isNotNull()

        enqueueResponse("popular_films.json")

        val testObserver = webService.getPopularFilms(page = 1)
            .map {
                it.data
            }.test()

        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        testObserver.assertValue {
            assertThat(it).isNotEmpty()
            assertThat(it[0].id).isEqualTo(297761)
            assertThat(it[1].id).isEqualTo(324668)
            it.size == 2
        }
        testObserver.assertComplete()
        testObserver.dispose()
    }

    @After
    fun `stop service`() {
        mockWebServer.shutdown()
    }

    private fun enqueueResponse(fileName: String) {
        val inputStream = javaClass.classLoader?.getResourceAsStream("api-response/$fileName")
            ?: return
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockWebServer.enqueue(
            mockResponse
                .setBody(source.readString(Charsets.UTF_8))
        )
    }
}
