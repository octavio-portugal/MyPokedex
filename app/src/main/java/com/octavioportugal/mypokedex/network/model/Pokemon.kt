package com.octavioportugal.mypokedex.network.model

data class Pokemon (
     val sprite: Sprite?,
     val name: String,
     val url: String
)

data class Sprite (
    val front_default: String?
)

data class PokemonWithoutIdResponse (
    val results : List<ResponseFromResult>
)

data class ResponseFromResult(
    val name : String,
    val url : String
)
