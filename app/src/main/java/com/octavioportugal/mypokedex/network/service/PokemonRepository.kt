package com.octavioportugal.mypokedex.network.service

import android.util.Log
import com.octavioportugal.mypokedex.network.model.Pokemon
import com.octavioportugal.mypokedex.network.model.PokemonWithoutIdResponse

class PokemonRepository {

    suspend fun getPokemonById(pokemonId: String): Pokemon? {
        val request = NetworkLayer.apiClient.getPokemonById(pokemonId)

        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }

    suspend fun getPokemonWithoutId(): PokemonWithoutIdResponse? {
        val request = NetworkLayer.apiClient.getPokemonWithoutId()

        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }

    suspend fun getPokemonInformation(): List<Pokemon>? {
        val request = NetworkLayer.apiClient.getPokemonWithoutId()

        if (request.isSuccessful) {
            Log.d("Resposta direta:", request.body().toString() )
            return request.body()?.results?.map {

                val getInformation = NetworkLayer.apiClient.getPokemonById(it.name)

                getInformation.body().let {
                    Pokemon(it!!.sprite, it.name, it.url)
                }
            }
        }
        return null
    }
}
