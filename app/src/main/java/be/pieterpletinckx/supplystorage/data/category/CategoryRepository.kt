package be.pieterpletinckx.supplystorage.data.category

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge


interface CategoryRepository {

    fun getCategories(): Flow<List<Category>>

    suspend fun updateCategories(categories: List<Category>)
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
    override fun getCategories(): Flow<List<Category>>  {
        return merge(
            fastCategoryRepository.getCategories(),
            slowCategoryRepository.getCategories().map {
                fastCategoryRepository.updateCategories(it) 
                it
            })
    }

    override suspend fun updateCategories(categories: List<Category>) {
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
}

/**
 * Offline Room DB
 */
class CategoryDatabaseRepository(private val category: CategoryDao): CategoryRepository {

    override fun getCategories(): Flow<List<Category>> = category.getAllCategories()

    override suspend fun updateCategories(categories: List<Category>) = category.update(categories)

}