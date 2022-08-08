package com.spacemooncake.filmapp.model

import com.spacemooncake.filmapp.model.entities.api_entities.Film

sealed class AppState {
    data class Success(val filmData: List<Film>) : AppState()
}
