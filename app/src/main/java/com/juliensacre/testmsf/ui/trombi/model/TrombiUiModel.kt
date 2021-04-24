package com.juliensacre.testmsf.ui.trombi.model

import com.juliensacre.testmsf.domain.trombi.DevModel

data class TrombiUiModel(
    val contentUiModel: TrombiContentUiModel? = null,
    val errorText: String? = null
)

data class TrombiContentUiModel(
    val listDevs: List<DevModel>
)

