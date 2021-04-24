package com.juliensacre.testmsf.ui.trombi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juliensacre.testmsf.domain.common.ResultState
import com.juliensacre.testmsf.domain.trombi.DevModel
import com.juliensacre.testmsf.domain.trombi.TrombiUseCase
import com.juliensacre.testmsf.ui.trombi.mapper.TrombiUiDataMapper
import com.juliensacre.testmsf.ui.trombi.model.TrombiUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class TrombiViewModel(
    private val trombiUseCase: TrombiUseCase,
    private val userMapperToUi: TrombiUiDataMapper
) : ViewModel() {
    private val uiMutableLiveData = MutableLiveData(TrombiUiModel())
    val uiLiveData: LiveData<TrombiUiModel>
        get() = uiMutableLiveData

    @InternalCoroutinesApi
    fun fetchTrombi() {
        viewModelScope.launch(Dispatchers.IO) {
            trombiUseCase.getTrombi().collect{
                result -> uiMutableLiveData.postValue(mapUiScreen(result))
            }
        }
    }

    private fun mapUiScreen(result: ResultState<List<DevModel>, String>): TrombiUiModel {
        return when (result) {
            is ResultState.Success -> {
                userMapperToUi.mapToUi(result.data)
            }
            is ResultState.Error -> {
                val error = result.error
                TrombiUiModel(errorText = error)
            }
        }
    }
}