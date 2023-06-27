package com.example.littlelemonapp.dagger

import android.content.SharedPreferences
import com.example.littlelemonapp.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)

}