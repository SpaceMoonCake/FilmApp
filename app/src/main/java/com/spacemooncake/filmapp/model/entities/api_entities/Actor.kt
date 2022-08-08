package com.spacemooncake.filmapp.model.entities.api_entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Actor(
    @SerializedName("actorName")
    val name: String
) : Parcelable
