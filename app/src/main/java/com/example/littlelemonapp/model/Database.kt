package com.example.littlelemonapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
data class MenuItemEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
)

@Dao
interface MenuDao {
    @Query("SELECT * FROM MenuItemEntity")
    fun getAllMenuItems(): LiveData<List<MenuItemEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMenuItem(menuItems: List<MenuItemEntity>)


    @Delete
    fun deleteMenuItem(menuItem: MenuItemEntity)
}

@Database(entities = [MenuItemEntity::class], version = 1)
abstract class MenuDatabase: RoomDatabase() {
    abstract fun menuDao(): MenuDao
}

fun transformFromResponseToDB(response: List<MenuItemNetwork>): List<MenuItemEntity> {
    var result = mutableListOf<MenuItemEntity>()

    response.forEach {
        result.add(
            MenuItemEntity(
            it.id,
            it.title,
            it.description,
            it.price,
            it.image,
            it.category
        )
        )
    }

    return result
}