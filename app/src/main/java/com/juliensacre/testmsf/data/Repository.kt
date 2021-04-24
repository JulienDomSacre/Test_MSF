package com.juliensacre.testmsf.data

import com.juliensacre.testmsf.data.local.room.user.TrombiDao
import com.juliensacre.testmsf.data.local.mapper.LocalMapper
import com.juliensacre.testmsf.data.remote.ApiResponse
import com.juliensacre.testmsf.data.remote.RemoteDataSource
import com.juliensacre.testmsf.data.remote.mapper.RemoteMapper
import com.juliensacre.testmsf.domain.common.ResultState
import com.juliensacre.testmsf.domain.repository.IRepository
import com.juliensacre.testmsf.domain.trombi.DevModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localTrombiDao: TrombiDao,
    private val mapToEntity: RemoteMapper,
    private val mapToModel: LocalMapper
) : IRepository {

    override fun getTrombi(): Flow<ResultState<List<DevModel>, String>> =
        flow {
            localTrombiDao.getTrombi().collect { localTrombi ->
                if (localTrombi.isEmpty()) {
                    remoteDataSource.getTrombi().collect {
                        when (it) {
                            is ApiResponse.Error -> emit(ResultState.Error(it.error))
                            is ApiResponse.Success -> localTrombiDao.insertAll(it.data.map { devResponse ->
                                mapToEntity.mapToDevEntity(
                                    devResponse
                                )
                            })
                        }
                    }
                } else {
                    emit(
                        ResultState.Success(localTrombi.map { devEntity ->
                            mapToModel.mapToDevModel(
                                devEntity
                            )
                        })
                    )
                }
            }
        }
}