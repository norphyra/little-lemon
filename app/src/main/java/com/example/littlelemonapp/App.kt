package com.example.littlelemonapp

import android.app.Application
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