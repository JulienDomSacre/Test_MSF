package com.juliensacre.testmsf.domain.trombi

import com.juliensacre.testmsf.domain.common.ResultState
import com.juliensacre.testmsf.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow

class TrombiUseCase(private val repo: IRepository) {

    fun getTrombi(): Flow<ResultState<List<DevModel>, String>> {
        return repo.getTrombi()
    }
}