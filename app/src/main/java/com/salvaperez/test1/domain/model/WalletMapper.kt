package com.salvaperez.test1.domain.model

import com.salvaperez.test1.data.api.DummyData
import com.salvaperez.test1.data.entity.*
import com.salvaperez.test1.presentation.extensions.roundTo
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt

fun CryptoWallet.toWalletModel(): WalletModel{
    return WalletModel(
        id = id,
        walletId = AssetCode.CRYPTO,
        coinId = cryptocoinId,
        isDefault = isDefault,
        balance = balance,
        deleted = deleted,
        name = name,
        asset = getAsset(cryptocoinId, AssetCode.CRYPTO)
    )
}

fun FiatWallet.toWalletModel(): WalletModel{
    return WalletModel(
        id = id,
        walletId = AssetCode.FIAT,
        coinId = fiatId,
        isDefault = isDefault,
        balance = balance,
        deleted = deleted,
        name = name,
        asset = getAsset(fiatId, AssetCode.FIAT)
    )
}

fun MetalWallet.toWalletModel(): WalletModel{
    return WalletModel(
        id = id,
        walletId = AssetCode.METAL,
        coinId = metalId,
        isDefault = isDefault,
        balance = balance,
        deleted = deleted,
        name = name,
        asset = getAsset(metalId, AssetCode.METAL)
    )
}

fun CryptoCoin.toAssetModel(): AssetModel{
    return AssetModel(
        precision = precision,
        name = name,
        symbol = symbol,
        id = id,
        price = price.roundTo(precision),
        logo = logo
    )
}

fun Metal.toAssetModel(): AssetModel{
    return AssetModel(
        precision = precision,
        name = name,
        symbol = name,
        id = id,
        price = price.roundTo(precision),
        logo = logo
    )
}

fun Fiat.toAssetModel(): AssetModel{
    return AssetModel(
        precision = precision,
        name = name,
        symbol = symbol,
        id = id,
        logo = logo,
        price = 1.0.roundTo(precision)
    )
}


private fun getAsset(id: String, assetCode: AssetCode): AssetModel? {
    return when {
        AssetCode.CRYPTO == assetCode -> {
            val asset = DummyData.cryptoCoins
            asset.find { metal -> metal.id == id }?.toAssetModel()
        }
        AssetCode.FIAT == assetCode -> {
            val asset = DummyData.fiats
            asset.find { metal -> metal.id == id }?.toAssetModel()
        }
        else -> {
            val asset = DummyData.metals
            asset.find { metal -> metal.id == id }?.toAssetModel()
        }
    }
}

enum class AssetCode {
    CRYPTO, METAL, FIAT
}