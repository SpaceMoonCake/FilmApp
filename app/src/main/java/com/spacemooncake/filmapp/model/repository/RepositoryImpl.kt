package com.spacemooncake.filmapp.model.repository

import com.spacemooncake.filmapp.model.api.FilmRepo
import com.spacemooncake.filmapp.model.entities.api_entities.Film

class RepositoryImpl : Repository {
    override fun getFilmsFromServer(): List<Film> {
        val filmData = FilmRepo.api.getFilms().execute().body()?.items!!
        val filmComparator = Comparator { p1: Film, p2: Film -> p1.releaseYear - p2.releaseYear }
        return filmData.sortedWith(filmComparator)
    }
}