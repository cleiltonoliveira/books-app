package com.example.todo

import androidx.annotation.DrawableRes

data class Book(
    val title: String, val description: String,
    @DrawableRes val imageResourceId: Int
) {


}