package com.salvaperez.test1.domain.model

import com.salvaperez.test1.data.api.ApiError
import com.salvaperez.test1.data.entity.ErrorEntity

fun ErrorEntity.toWalletError(): ApiError {
    return when (code) {
        500 -> ApiError.ServerError()
        else -> ApiError.Unknown()
    }
}