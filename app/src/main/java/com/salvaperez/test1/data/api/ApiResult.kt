package com.salvaperez.test1.data.api

sealed class ApiResult<out Failure, out Success> {

    data class Failure<out Failure>(val failure: Failure) : ApiResult<Failure, Nothing>()

    data class Success<out Success>(val success: Success) : ApiResult<Nothing, Success>()

    val isSuccess get() = this is ApiResult.Success<Success>
    val isFailure get() = this is ApiResult.Failure<Failure>

}

fun <Failure, Success, T> ApiResult<Failure, Success>.fold(failure: (Failure) -> T, success: (Success) -> T): T =
    when (this) {
        is ApiResult.Failure -> failure(this.failure)
        is ApiResult.Success -> success(this.success)
    }