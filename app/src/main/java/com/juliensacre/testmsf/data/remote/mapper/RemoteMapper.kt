package com.juliensacre.testmsf.data.remote.mapper

import com.juliensacre.testmsf.data.local.entity.DevEntity
import com.juliensacre.testmsf.data.remote.response.Dev

class RemoteMapper {
    fun mapToDevEntity(
        response: Dev
    ): DevEntity {
        return DevEntity(
            id = response.id.toInt(),
            name = response.name,
            description = response.description,
            picture = response.picture,
            hired = response.hired.name
        )
    }
}