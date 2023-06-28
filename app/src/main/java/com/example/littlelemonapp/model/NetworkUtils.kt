package com.example.littlelemonapp.model

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import retrofit2.http.GET
import javax.inject.Inject

interface NetworkUtils {
    @GET("menu.json")
    suspend fun getMenuItems(): MenuNetwork
}