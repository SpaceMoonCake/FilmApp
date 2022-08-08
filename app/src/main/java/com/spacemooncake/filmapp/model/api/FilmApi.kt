package com.spacemooncake.filmapp.model.api

import com.spacemooncake.filmapp.model.entities.api_entities.DataFilm
import retrofit2.Call
import retrofit2.http.GET

interface FilmApi {
    @GET("films.json")
    fun getFilms(): Call<DataFilm>
}