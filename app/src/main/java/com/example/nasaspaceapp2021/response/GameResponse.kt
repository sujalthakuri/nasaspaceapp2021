package com.example.nasaspaceapp2021.response

import com.example.nasaspaceapp2021.entity.Game

data class GameResponse (
    val success : Boolean? = null,
    val data : List<Game>? = null
)