package com.juliensacre.testmsf.domain.trombi

data class DevModel(
    val id: Int,
    val name: String,
    val description: String,
    val picture: String,
    val hired: IsHired
)

//I think this name is not very good :(
enum class IsHired{
    Y, N
}
