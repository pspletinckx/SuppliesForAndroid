package be.pieterpletinckx.supplystorage.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import be.pieterpletinckx.supplystorage.data.category.Category
import be.pieterpletinckx.supplystorage.data.category.CategoryDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CategoryDatabaseTest {

    private lateinit var categoryDao: CategoryDao
    private lateinit var db: InventoryDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, InventoryDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        categoryDao = db.categoryDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
    }

    @Test
    @Throws(Exception::class)
    fun addOneAndRetreive() = runBlocking {
        val category = Category(name = "Drinks", imageUrl = "Https://abc", image = 0)
        val categoryList = listOf(category)

        categoryDao.insert(categoryList)
        val queryResult = categoryDao.getAllCategories().first()
        Assert.assertEquals(1, queryResult.size)
    }
}