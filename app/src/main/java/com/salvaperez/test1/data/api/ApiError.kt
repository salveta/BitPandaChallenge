package com.salvaperez.test1.data.api

import java.lang.Exception

sealed class ApiError: Exception() {

    class ServerError: ApiError()
    class Unknown: ApiError()

}