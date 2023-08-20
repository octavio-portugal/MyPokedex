package com.octavioportugal.mypokedex.features.PokemonList.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.octavioportugal.mypokedex.R
import com.octavioportugal.mypokedex.databinding.FragmentPokedexBinding

class PokedexFragment : Fragment(R.layout.fragment_pokedex) {

    private lateinit var binding: FragmentPokedexBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPokedexBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}