package com.octavioportugal.mypokedex.network.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkLayer {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val pokemonService: IApiService by lazy {
        retrofit.create(IApiService::class.java)
    }
    val apiClient = ApiClient(pokemonService)
}