package com.octavioportugal.mypokedex.features.PokemonList.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.octavioportugal.mypokedex.R
import com.octavioportugal.mypokedex.databinding.FragmentPokedexBinding
import com.octavioportugal.mypokedex.features.PokemonList.view.adapter.PokedexRecyclerAdapter
import com.octavioportugal.mypokedex.features.PokemonList.viewmodel.PokedexViewModel
import com.octavioportugal.mypokedex.network.model.Pokemon

class PokedexFragment : Fragment(R.layout.fragment_pokedex) {

    private lateinit var binding: FragmentPokedexBinding

    val viewModel: PokedexViewModel by lazy {
        ViewModelProvider(this).get(PokedexViewModel::class.java)
    }

    private lateinit var pokedexAdapter: PokedexRecyclerAdapter
    private lateinit var pokemonList : ArrayList<Pokemon>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPokedexBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonList = ArrayList<Pokemon>()

        setupViewmodel()
        setupObserver()

    }

    private fun setupAdapter(pokemonList: ArrayList<Pokemon>){
        pokedexAdapter = PokedexRecyclerAdapter(pokemonList)
        binding.recyclerPokedex.adapter = pokedexAdapter
        binding.recyclerPokedex.layoutManager = LinearLayoutManager(requireContext())
        pokedexAdapter
    }

    private fun setupViewmodel(){
        viewModel.refreshListOfPokemonsWithoutId()
    }

    private fun setupObserver() {
        val value = viewModel.pokemonData.observe(requireActivity()){
            pokemonList = it as ArrayList<Pokemon>
            Log.d("PokemonData3:", it.toString())
        }
        return value
    }

    private fun updateAdapter(value: ArrayList<Pokemon>){
        pokedexAdapter.items.clear()
        pokedexAdapter.items.addAll(value)
        pokedexAdapter.notifyDataSetChanged()
    }
}