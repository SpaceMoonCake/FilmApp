package com.spacemooncake.filmapp.model.repository

import com.spacemooncake.filmapp.model.entities.api_entities.Film

interface Repository {
    fun getFilmsFromServer(): List<Film>
}