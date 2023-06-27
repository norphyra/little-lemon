package com.example.littlelemonapp.model

import android.content.Context
import androidx.room.Room
import javax.inject.Inject

class DatabaseHelper @Inject constructor(private val context: Context) {

    public val database by lazy {
        Room.databaseBuilder(
            context.applicationContext,
            MenuDatabase::class.java,
            "menu.db"
        ).build()
    }

}