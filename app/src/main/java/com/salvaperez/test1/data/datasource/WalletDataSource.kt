package com.salvaperez.test1.data.datasource

import com.salvaperez.test1.data.api.ApiError
import com.salvaperez.test1.data.api.ApiResult
import com.salvaperez.test1.data.entity.*

interface WalletDataSource {

    suspend fun getCryptoWallets(): ApiResult<ErrorEntity, List<CryptoWallet>>

    suspend fun getMetalWallets(): ApiResult<ErrorEntity, List<MetalWallet>>

    suspend fun getFiatWallets(): ApiResult<ErrorEntity, List<FiatWallet>>

    suspend fun getCryptoCoins(): ApiResult<ErrorEntity, List<CryptoCoin>>

    suspend fun getMetals(): ApiResult<ErrorEntity, List<Metal>>

    suspend fun getFiats(): ApiResult<ErrorEntity, List<Fiat>>
}