package com.salvaperez.test1.data.entity

data class Metal(
    var precision: Int = 3,
    var name: String,
    var symbol: String,
    var id: String,
    var price: Double,
    val logo: String)