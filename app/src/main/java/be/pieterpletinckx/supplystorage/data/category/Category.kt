package be.pieterpletinckx.supplystorage.data.category

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Category Class an Item can belong to ,
 * has a 1 to N relationship with Item
 */
@Entity(tableName = "category")
@Serializable
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId: Int = 0,
    val name: String,
    @DrawableRes val image: Int= 0,
    @SerialName(value = "imageUrl")
    val imageUrl: String = ""
)
