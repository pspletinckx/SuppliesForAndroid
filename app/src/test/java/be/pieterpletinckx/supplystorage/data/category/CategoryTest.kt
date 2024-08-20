package be.pieterpletinckx.supplystorage.data.category

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CategoryTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testSerialisationWorks() {
        val category1 = Json.encodeToString(Category(name = "strin", imageUrl = "image", image = 0))
        Assert.assertNotNull(category1)
    }

    @Serializable
    data class Data(val a: Int, val b: String)

    @Test
    fun Serial() {

        val json = Json.encodeToString(Data(42, "str"))
        Assert.assertNotNull(json)
    }
}