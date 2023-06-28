package com.example.littlelemonapp.dagger

import android.content.Context
import android.content.SharedPreferences
import androidx.activity.ComponentActivity
import com.example.littlelemonapp.model.NetworkUtils
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.Converter.Factory
import retrofit2.converter.gson.GsonConverterFactory

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

@Module
class NetworkModule {
    @Provides
    fun getNetworkUtils(): NetworkUtils {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}