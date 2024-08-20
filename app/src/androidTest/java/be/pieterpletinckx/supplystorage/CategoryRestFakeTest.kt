package be.pieterpletinckx.supplystorage

import be.pieterpletinckx.supplystorage.data.category.Category
import be.pieterpletinckx.supplystorage.data.category.CategoryApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

class CategoryRestFakeTest {
    private lateinit var server: MockWebServer
    private lateinit var api: CategoryApiService

    @Before
    fun beforeEach() {
        server = MockWebServer()
        api = Retrofit.Builder()
            .baseUrl(server.url("/"))//Pass any base url like this
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(CategoryApiService::class.java)
    }
    @After
    fun afterEach() {
        server.shutdown()
    }

    @Test
    fun getTest(): Unit = runTest {
        Assert.assertNull(api.getCategories().first())
    }

}