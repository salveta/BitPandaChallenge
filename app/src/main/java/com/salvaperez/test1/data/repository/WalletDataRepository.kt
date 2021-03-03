package com.salvaperez.test1.data.repository

import com.salvaperez.test1.data.api.ApiError
import com.salvaperez.test1.data.api.ApiResult
import com.salvaperez.test1.data.api.DummyData
import com.salvaperez.test1.data.api.fold
import com.salvaperez.test1.data.datasource.DummyWebService
import com.salvaperez.test1.data.entity.CryptoWallet
import com.salvaperez.test1.data.entity.FiatWallet
import com.salvaperez.test1.data.entity.MetalWallet
import com.salvaperez.test1.domain.model.AssetCode
import com.salvaperez.test1.domain.model.WalletModel
import com.salvaperez.test1.domain.model.toAssetModel
import com.salvaperez.test1.domain.model.toWalletModel
import com.salvaperez.test1.domain.repository.WalletRepository

class WalletDataRepository(private val walletHelper: WalletHelper): WalletRepository {

    override suspend fun getWallets(): ApiResult<ApiError, List<WalletModel>> {
        val cryptoWallet =  DummyData.dummyCryptoWalletList
        val fiatWallet =  DummyData.dummyEURWallet
        val metalWallet =  DummyData.dummyMetalWalletList

        val result = walletHelper.parseWallets(cryptoWallet, fiatWallet, metalWallet)
        return result.fold(
            { errorEntity -> ApiResult.Failure(errorEntity) },
            { dataEntity ->
                ApiResult.Success(dataEntity.map { it }) }
        )
    }


    override suspend fun  getFilterCurrencies(): ApiResult<ApiError, List<WalletModel>>  {
        val randomNumber = (0..2).random()
        val result = walletHelper.getRandomCurrency(randomNumber)
        return result.fold(
                { errorEntity -> ApiResult.Failure(errorEntity) },
                { dataEntity ->
                    ApiResult.Success(dataEntity.map { it }) }
        )
    }
}