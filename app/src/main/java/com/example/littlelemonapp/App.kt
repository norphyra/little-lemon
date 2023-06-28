package com.example.littlelemonapp

import android.app.Application
import android.content.Context
import com.example.littlelemonapp.dagger.AppComponent
import com.example.littlelemonapp.dagger.AppModule
import com.example.littlelemonapp.dagger.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

}

val Context.appComponent: AppComponent
    get() = when(this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }