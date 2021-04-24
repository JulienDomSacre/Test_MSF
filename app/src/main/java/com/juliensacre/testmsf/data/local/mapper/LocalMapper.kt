package com.juliensacre.testmsf.data.local.mapper

import com.juliensacre.testmsf.data.local.entity.DevEntity
import com.juliensacre.testmsf.domain.trombi.DevModel
import com.juliensacre.testmsf.domain.trombi.IsHired

class LocalMapper {

    fun mapToDevModel(
        entity: DevEntity
    ): DevModel {
        return DevModel(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            picture = entity.picture,
            hired = IsHired.valueOf(entity.hired)
        )
    }
}