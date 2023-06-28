package com.example.littlelemonapp.model

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface MenuRepository {
    suspend fun getMenu(): List<MenuItemEntity>

    suspend fun getMenuItemsByCategory(category: String): List<MenuItemEntity>
}

class MenuRepositoryImpl @Inject constructor(
    private val networkUtils: NetworkUtils,
    private val databaseHelper: DatabaseHelper): MenuRepository {

    override suspend fun getMenu(): List<MenuItemEntity> {

        val response = networkUtils.getMenuItems()

        val responseToDb = transformFromResponseToDB(response.menu)

        withContext(IO) {
            databaseHelper.database.menuDao().saveMenuItem(responseToDb)
        }

        return responseToDb
    }

    override suspend fun getMenuItemsByCategory(category: String): List<MenuItemEntity> {
        return databaseHelper.database.menuDao().getMenuItemsByCategory(category)
    }

}
