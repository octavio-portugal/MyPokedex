package com.octavioportugal.mypokedex.features.PokemonList.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.octavioportugal.mypokedex.databinding.ItemPokemonListBinding
import com.octavioportugal.mypokedex.network.model.Pokemon
import com.squareup.picasso.Picasso

class PokedexRecyclerAdapter(var items: ArrayList<Pokemon>) : RecyclerView.Adapter<PokedexHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexHolder {
        val binding =
            ItemPokemonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PokedexHolder(binding)
    }

    override fun onBindViewHolder(holder: PokedexHolder, position: Int) {

        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class PokedexHolder(private val binding: ItemPokemonListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Pokemon) {
        binding.tvPokemonName.text = data.name

        Picasso.get().load(data.sprite?.front_default).centerCrop().resize(120, 120)
            .into(binding.imgPokemonPokedex)
    }
}
