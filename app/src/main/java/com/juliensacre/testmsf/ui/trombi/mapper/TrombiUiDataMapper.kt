package com.juliensacre.testmsf.ui.trombi.mapper

import com.juliensacre.testmsf.domain.trombi.DevModel
import com.juliensacre.testmsf.ui.trombi.model.TrombiContentUiModel
import com.juliensacre.testmsf.ui.trombi.model.TrombiUiModel

class TrombiUiDataMapper {
    fun mapToUi(data: List<DevModel>): TrombiUiModel {
        return TrombiUiModel(
            contentUiModel = TrombiContentUiModel(
                listDevs = data
            ),
            errorText = null
        )
    }
}
