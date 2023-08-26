package com.octavioportugal.mypokedex.network.service

import com.octavioportugal.mypokedex.network.model.Pokemon
import com.octavioportugal.mypokedex.network.model.PokemonWithoutIdResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiService {

    @GET("pokemon/{id}")
    suspend fun getPokemonById(
        @Path("id") pokemonId: String
    ) : Response<Pokemon>

    @GET("pokemon/?offset=0&limit=50")
    suspend fun getPokemonListWithoutId() : Response<PokemonWithoutIdResponse>
}