package be.pieterpletinckx.supplystorage

import be.pieterpletinckx.supplystorage.data.category.CategoryApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

class CategoryTest {
    private lateinit var api: CategoryApiService

    @Before
    fun beforeEach() {
        api = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl("https://supplystorage.pieterpletinckx.be/")
            .build()
            .create(CategoryApiService::class.java)
    }
    @After
    fun afterEach() {
    }

    @Test
    fun getTest(): Unit = runTest {
        val first = api.getCategories().first()
        Assert.assertNotNull(first)
        print(first)
    }
}