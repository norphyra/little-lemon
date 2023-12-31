package com.example.littlelemonapp.navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemonapp.Home
import com.example.littlelemonapp.OnBoarding
import com.example.littlelemonapp.Profile
import com.example.littlelemonapp.model.MenuItemEntity

@Composable
fun Navigation(
    navController: NavHostController, sharedPreferences: SharedPreferences,
    menuItems: LiveData<List<MenuItemEntity>>, onClick: (String) -> Unit) {

    var startDestination = Onboarding.route

    if (sharedPreferences.getBoolean("isLogin", false)) {
        startDestination = Home.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route) {
            OnBoarding(navController = navController, sharedPreferences = sharedPreferences)
        }
        composable(Home.route) {
            Home(navController = navController, menuItems, onClick)
        }
        composable(Profile.route) {
            Profile(navController = navController, sharedPreferences = sharedPreferences)
        }
    }
}
