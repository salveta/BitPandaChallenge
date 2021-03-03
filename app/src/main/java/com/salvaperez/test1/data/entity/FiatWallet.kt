package com.salvaperez.test1.data.entity

data class FiatWallet(
    var id: String,
    var fiatId: String,
    var isDefault: Boolean,
    var balance: Double,
    var deleted: Boolean,
    var name: String)