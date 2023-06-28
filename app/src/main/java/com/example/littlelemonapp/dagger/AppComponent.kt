package com.example.littlelemonapp.dagger

import android.content.Context
import android.content.SharedPreferences
import com.example.littlelemonapp.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)

}