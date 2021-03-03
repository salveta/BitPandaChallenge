package com.salvaperez.test1.domain.repository

import com.salvaperez.test1.data.api.ApiError
import com.salvaperez.test1.data.api.ApiResult
import com.salvaperez.test1.domain.model.WalletModel

interface WalletRepository {

    suspend fun getWallets(): ApiResult<ApiError, List<WalletModel>>

    suspend fun getFilterCurrencies(): ApiResult<ApiError, List<WalletModel>>

}