package com.spacemooncake.filmapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spacemooncake.filmapp.databinding.FilmItemBinding
import com.spacemooncake.filmapp.model.entities.api_entities.Film
import com.spacemooncake.filmapp.ui.main.MainFragment

class MainFragmentAdapter(private val itemClickListener: MainFragment.OnItemViewClickListener) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {
    private var filmsData: List<Film> = listOf()
    private lateinit var binding: FilmItemBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setFilms(data: List<Film>) {
        filmsData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = FilmItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(filmsData[position])
    }

    override fun getItemCount() = filmsData.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind(film: Film) = with(binding) {
            filmTitle.text = "${film.name} (${film.releaseYear})"
            director.text = "Режиссёр: ${film.getDirectorFamilyAndInitials()}"
            actors.text = film.getActors()
            root.setOnClickListener { itemClickListener.onItemViewClick(film) }
        }
    }


}