package com.appdev.mywheatherapplication.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sys(
    val country: String,
    val sunrise: Int,
    val sunset: Int
)