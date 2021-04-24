package com.juliensacre.testmsf.data.remote.response

import com.juliensacre.testmsf.domain.trombi.IsHired

data class TrombiResponse(
    val list: List<Dev>
)
data class Dev(
    val id: String,
    val name: String,
    val description: String,
    val picture: String,
    val hired: IsHired
)

