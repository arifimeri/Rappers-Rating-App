package com.example.rappersratingapp

import java.io.Serializable

data class Rapper(
    val rank: Int,
    val firstName: String,
    val lastName: String,
    val famousSong: String,
    val salary: Int
) : Serializable