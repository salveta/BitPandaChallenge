package com.salvaperez.test1.domain.model

data class WalletModel( var id: String,
                        var walletId: AssetCode,
                         var coinId: String,
                         var isDefault: Boolean,
                         var balance: Double,
                         var deleted: Boolean,
                         var name: String,
                         var asset: AssetModel?)