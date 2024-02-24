package com.example.myapplication.model
import java.io.Serializable
data class Pizza(
    val image: Int,
    val title: String,
    val description: String,
    val price: Int
): Serializable
