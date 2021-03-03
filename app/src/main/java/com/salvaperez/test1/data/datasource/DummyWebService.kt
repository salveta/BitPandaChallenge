package com.salvaperez.test1.data.datasource

import com.salvaperez.test1.data.api.ApiResult
import com.salvaperez.test1.data.api.DummyData
import com.salvaperez.test1.data.entity.*

class DummyWebService: WalletDataSource  {

    override suspend fun getCryptoWallets(): ApiResult<ErrorEntity, List<CryptoWallet>> {
        val cryptoData =  DummyData.dummyCryptoWalletList
        return ApiResult.Success(cryptoData)
    }

    override suspend fun getMetalWallets(): ApiResult<ErrorEntity, List<MetalWallet>> {
        val cryptoData =  DummyData.dummyMetalWalletList
        return ApiResult.Success(cryptoData)
    }

    override suspend fun getFiatWallets(): ApiResult<ErrorEntity, List<FiatWallet>> {
        val cryptoData =  DummyData.dummyEURWallet
        return ApiResult.Success(cryptoData)
    }

    override suspend fun getCryptoCoins(): ApiResult<ErrorEntity, List<CryptoCoin>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMetals(): ApiResult<ErrorEntity, List<Metal>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFiats(): ApiResult<ErrorEntity, List<Fiat>> {
        TODO("Not yet implemented")
    }

    //    fun getCryptoWallets(): List<CryptoWallet> {
//        return DummyData.dummyCryptoWalletList
//    }
//
//    fun getMetalWallets(): List<MetalWallet> {
//        return DummyData.dummyMetalWalletList
//    }
//
//    fun getFiatWallets(): List<FiatWallet> {
//        return DummyData.dummyEURWallet
//    }
//
//    fun getCryptocoins(): List<CryptoCoin> {
//        return DummyData.cryptoCoins
//    }
//
//    fun getMetals(): List<Metal> {
//        return DummyData.metals
//    }
//
//    fun getFiats(): List<Fiat> {
//        return DummyData.fiats
//    }

//    fun getCurrencies(): List<IMPLEMENT_ME> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

}