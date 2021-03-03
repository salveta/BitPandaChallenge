package com.salvaperez.test1.data.repository

import com.salvaperez.test1.data.api.ApiError
import com.salvaperez.test1.data.api.ApiResult
import com.salvaperez.test1.data.entity.CryptoWallet
import com.salvaperez.test1.data.entity.FiatWallet
import com.salvaperez.test1.data.entity.MetalWallet
import com.salvaperez.test1.domain.model.WalletModel
import com.salvaperez.test1.domain.model.toWalletModel

class WalletHelper {

    fun parseWallets(crypto: List<CryptoWallet>,
                             fiat: List<FiatWallet>,
                             metal: List<MetalWallet>): ApiResult<ApiError, List<WalletModel>> {
        val wallet : MutableList<WalletModel> = ArrayList()

        val fiatSorted = fiat.sortedByDescending { sorted -> sorted.balance }
        val cryptoSorted = crypto.sortedByDescending { sorted -> sorted.balance }
        val metalSorted = metal.sortedByDescending { sorted -> sorted.balance }

        fiatSorted.forEach { coin -> wallet.add(coin.toWalletModel()) }
        cryptoSorted.forEach { coin -> wallet.add(coin.toWalletModel()) }
        metalSorted.forEach { coin -> wallet.add(coin.toWalletModel()) }

        val walletList = wallet.toList().filter { coin -> !coin.deleted }
        filterCurrencies = ArrayList(walletList)
        return ApiResult.Success(walletList)
    }

    fun getRandomCurrency(randomNumber: Int): ApiResult<ApiError, List<WalletModel>> {
        return  ApiResult.Success(filterCurrencies.filter { currency -> currency.walletId.ordinal == randomNumber})
    }

    companion object {
        private var filterCurrencies : MutableList<WalletModel> = ArrayList()
    }
}