package com.example.littlelemonapp.navigation

import android.content.SharedPreferences
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemonapp.Home
import com.example.littlelemonapp.OnBoarding
import com.example.littlelemonapp.Profile

@Composable
fun Navigation(navController: NavHostController, sharedPreferences: SharedPreferences) {

    var startDestination = Onboarding.route

    if (sharedPreferences.getBoolean("isLogin", false)) {
        startDestination = Home.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route) {
            OnBoarding(navController = navController, sharedPreferences = sharedPreferences)
        }
        composable(Home.route) {
            Home()
        }
        composable(Profile.route) {
            Profile()
        }
    }
}
