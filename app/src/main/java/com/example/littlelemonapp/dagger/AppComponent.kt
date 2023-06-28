package com.example.littlelemonapp.dagger

import com.example.littlelemonapp.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class, ViewModelModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)

}