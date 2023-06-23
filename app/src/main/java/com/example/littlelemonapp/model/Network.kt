package com.example.littlelemonapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    val menu: List<MenuItemEntity>
)

//@Serializable
//data class MenuItemNetwork(
//    val id: Int,
//    val title: String,
//    val description: String,
//    val price: String,
//    val image: String,
//    val category: String
//)