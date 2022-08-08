package com.spacemooncake.filmapp.model.entities.api_entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataFilm(
    val items: List<Film>
) : Parcelable
