package com.juliensacre.testmsf.data.remote.api

import com.juliensacre.testmsf.data.remote.response.TrombiResponse
import retrofit2.http.GET

interface TrombiService {
    @GET("trombi")
    suspend fun getTrombi(): TrombiResponse
}