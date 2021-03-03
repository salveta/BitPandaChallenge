package com.salvaperez.test1.domain.use_case

import com.salvaperez.test1.data.api.ApiError
import com.salvaperez.test1.data.api.fold
import com.salvaperez.test1.domain.model.WalletModel
import com.salvaperez.test1.domain.repository.WalletRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCurrency(private val walletRepository: WalletRepository) {

    suspend operator fun invoke(
            onGetCurrencySuccess: (data: List<WalletModel>) -> Unit,
            onGetCurrencyError: (data: ApiError) -> Unit
    ) {

        val result = withContext(Dispatchers.IO){
            walletRepository.getFilterCurrencies()
        }

        result.fold(
                failure = { error -> onGetCurrencyError(error) },
                success = { data -> onGetCurrencySuccess(data) }
        )
    }

}