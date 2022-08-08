package com.spacemooncake.filmapp.model.entities.api_entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    @SerializedName("title")
    val name: String,
    val directorName: String,
    val releaseYear: Int,
    val actors: Set<Actor>
) : Parcelable {

    fun getDirectorFamilyAndInitials(): String {
        val fioArray: List<String> = directorName.split(" ")
        var result: String = fioArray[2] + " "
        for (i in 0..1) {
            result += fioArray[i].substring(0, 1).uppercase() + "."
        }
        return result
    }

    fun getActors(): String {
        var result = ""
        for (i in actors.indices) {
            result += if (i == actors.size - 1) {
                actors.elementAt(i).name + "."
            } else {
                actors.elementAt(i).name + ", "
            }
        }
        return result
    }
}
