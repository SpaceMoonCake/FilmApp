package com.spacemooncake.filmapp.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FilmRepo {
    val api: FilmApi by lazy {
        val adapter = Retrofit.Builder()
            .baseUrl(ApiUtils.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(ApiUtils.getOkHTTPBuilderWithHeaders())
            .build()
        adapter.create(FilmApi::class.java)
    }
}