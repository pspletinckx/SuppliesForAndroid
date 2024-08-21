package be.pieterpletinckx.supplystorage.data.category

import android.util.Log
import coil.network.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import java.io.IOException


interface CategoryRepository {

    fun getCategories(): Flow<List<Category>>

    suspend fun updateCategories(categories: List<Category>)
    suspend fun insertCategories(categories: List<Category>): List<Long>
    suspend fun deleteAllCategories()
}

/**
 * Cached Strategy: Offline (fast) first, then update with online
 */
class CategoryCachedRepository(
    private val fastCategoryRepository: CategoryRepository,
    private val slowCategoryRepository: CategoryRepository): CategoryRepository {

    /**
     * Initiate the retrieval, return the offline Categories, return
     */
    override fun getCategories(): Flow<List<Category>> = merge(
        fastCategoryRepository.getCategories(),
        slowCategoryRepository.getCategories()
            .catch { e ->
                if (e !is IOException) Log.e("Category", e.message!!)
            }
            .map {
                fastCategoryRepository.insertCategories(it)
                it
            })

    override suspend fun updateCategories(categories: List<Category>) {
        TODO("Not yet implemented")
    }

    override suspend fun insertCategories(categories: List<Category>): List<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllCategories() {
        TODO("Not yet implemented")
    }
}

/**
 * Online Retrofit
 */
class CategoryNetworkRepository(private val categoryApiService: CategoryApiService): CategoryRepository {
    override fun getCategories(): Flow<List<Category>> = flow {
        emit(categoryApiService.getCategories())
    }

    override suspend fun updateCategories(categories: List<Category>) {
        TODO("Not yet implemented")
    }

    override suspend fun insertCategories(categories: List<Category>): List<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllCategories() {
        TODO("Not yet implemented")
    }
}

/**
 * Offline Room DB
 */
class CategoryDatabaseRepository(private val category: CategoryDao): CategoryRepository {

    override fun getCategories(): Flow<List<Category>> = category.getAllCategories()

    override suspend fun updateCategories(categories: List<Category>) = category.update(categories)

    override suspend fun insertCategories(categories: List<Category>) = category.insert(categories)

    override suspend fun deleteAllCategories() = category.deleteAll()

}