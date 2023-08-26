package com.octavioportugal.mypokedex.features.PokemonList.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.octavioportugal.mypokedex.features.PokemonList.model.toPokemonMapper
import com.octavioportugal.mypokedex.network.model.Pokemon
import com.octavioportugal.mypokedex.network.service.PokemonRepository
import kotlinx.coroutines.launch
import kotlin.math.log

class PokedexViewModel : ViewModel() {

    private val repository = PokemonRepository()

    private var _pokemonData = MutableLiveData<List<Pokemon>>()
    val pokemonData: LiveData<List<Pokemon>> = _pokemonData

//    fun refreshPokemon(pokemonId: String){
//        viewModelScope.launch {
//            val response = repository.getPokemonById(pokemonId)
//
//            _pokemonByIdLiveData.postValue(listOf(response))
//        }
//    }

    fun refreshListOfPokemonsWithoutId() {
        viewModelScope.launch {
            val response = repository.getPokemonWithoutId()

            val value = response.let {
                Log.d("API response:", it.toString())
                it?.results?.map {
                    it.toPokemonMapper(it.name, it.url)
                }
            }

            _pokemonData.value = value!!
            Log.d("PokemonData4:", pokemonData.value.toString())
        }
    }

//    fun refreshPokemon() {
//        viewModelScope.launch {
//            val response = repository.getPokemonInformation()
//
//            _pokemonByIdLiveData.postValue(response)
//        }
//    }
}
