package com.octavioportugal.mypokedex.features.PokemonList.model

import com.octavioportugal.mypokedex.network.model.Pokemon
import com.octavioportugal.mypokedex.network.model.ResponseFromResult

fun ResponseFromResult.toPokemonMapper( name : String, url : String): Pokemon{
    return Pokemon(null, name = name, url = url)
}