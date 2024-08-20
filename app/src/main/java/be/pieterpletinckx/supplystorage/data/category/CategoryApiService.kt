package be.pieterpletinckx.supplystorage.data.category

import retrofit2.http.GET

interface CategoryApiService {

    @GET("categories")
    suspend fun getCategories(): List<Category>
}