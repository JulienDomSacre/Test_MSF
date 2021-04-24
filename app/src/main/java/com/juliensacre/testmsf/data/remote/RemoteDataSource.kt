package com.juliensacre.testmsf.data.remote

import com.juliensacre.testmsf.data.remote.api.TrombiService
import com.juliensacre.testmsf.data.remote.response.Dev
import com.juliensacre.testmsf.data.remote.response.TrombiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.net.SocketTimeoutException

class RemoteDataSource(
    private val trombiService: TrombiService
) {

    fun getTrombi(): Flow<ApiResponse<List<Dev>>> {
        return flow {
            try {
                val response = trombiService.getTrombi()
                if (response.list.isNotEmpty())
                    emit(ApiResponse.Success(response.list))
                else
                    emit(ApiResponse.Error("Empty data"))
            } catch (e: Exception) {
                emit(ApiResponse.Error(mapException(e)))
            }
        }
    }

    private fun mapException(exception: Exception): String {
        return when (exception) {
            is SocketTimeoutException -> "TimeOutError"
            is IOException -> "NoNetworkError"
            else -> exception.message ?: "Unknown error"
        }
    }
}