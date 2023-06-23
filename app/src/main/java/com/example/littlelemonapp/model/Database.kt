package com.example.littlelemonapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class MenuItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
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


    @Insert
    fun saveMenuItem(menuItems: List<MenuItemEntity>)


    @Delete
    fun deleteMenuItem(menuItem: MenuItemEntity)
}

@Database(entities = [MenuItemEntity::class], version = 1)
abstract class MenuDatabase: RoomDatabase() {
    abstract fun menuDao(): MenuDao
}