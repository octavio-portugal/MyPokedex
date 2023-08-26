package com.octavioportugal.mypokedex.network.service

import com.octavioportugal.mypokedex.network.model.Pokemon
import com.octavioportugal.mypokedex.network.model.PokemonWithoutIdResponse
import retrofit2.Response

class ApiClient (private val pokemonService: IApiService){

    suspend fun getPokemonById(pokemonId: String): Response<Pokemon> {
        return pokemonService.getPokemonById(pokemonId)
    }

    suspend fun getPokemonWithoutId(): Response<PokemonWithoutIdResponse> {
        return pokemonService.getPokemonListWithoutId()
    }
}