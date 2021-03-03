package com.salvaperez.test1.data.entity

data class CryptoCoin(
    var precision: Int = 4,
    var name: String,
    var symbol: String,
    var id: String,
    var price: Double,
    var logo: String)