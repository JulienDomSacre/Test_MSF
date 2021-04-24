package com.juliensacre.testmsf.domain.repository

import com.juliensacre.testmsf.domain.common.ResultState
import com.juliensacre.testmsf.domain.trombi.DevModel
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getTrombi(): Flow<ResultState<List<DevModel>, String>>
}