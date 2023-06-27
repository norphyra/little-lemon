package com.example.littlelemonapp.dagger

import android.content.Context
import android.content.SharedPreferences
import androidx.activity.ComponentActivity
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun getAppContext(): Context {
        return context
    }

    @Provides
    fun getPreferences(): SharedPreferences {
        return context.getSharedPreferences("LittleLemon", ComponentActivity.MODE_PRIVATE)
    }
}