package com.salvaperez.test1.data.entity

data class MetalWallet(
    var id: String,
    var metalId: String,
    var isDefault: Boolean,
    var balance: Double,
    var deleted: Boolean,
    var name: String
)