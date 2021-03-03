package com.salvaperez.test1.domain.use_case

import com.salvaperez.test1.data.api.ApiError
import com.salvaperez.test1.data.api.fold
import com.salvaperez.test1.domain.model.WalletModel
import com.salvaperez.test1.domain.repository.WalletRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetWallets(private val walletRepository: WalletRepository) {

    suspend operator fun invoke(
        onGetWalletSuccess: (data: List<WalletModel>) -> Unit,
        onGetWalletError: (data: ApiError) -> Unit
    ) {

        val result = withContext(Dispatchers.IO){
            walletRepository.getWallets()
        }

        result.fold(
            failure = { error -> onGetWalletError(error) },
            success = { data -> onGetWalletSuccess(data) }
        )
    }

}