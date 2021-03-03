package com.salvaperez.test1.data.entity

data class CryptoWallet(
    var id: String,
    var cryptocoinId: String,
    var isDefault: Boolean,
    var balance: Double,
    var deleted: Boolean,
    var name: String)