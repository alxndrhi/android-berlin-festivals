package dev.hinrichs.berlinfestivals.data.remote

import com.squareup.moshi.Json
import java.time.LocalDate

data class FestivalDto(
    val id: String,
    val bild: String,
    val copyright: String,
    val bezirk: String,
    val bezeichnung: String,
    val strasse: String,
    val plz: String,
    val von: LocalDate,
    val bis: LocalDate,
    val zeit: String,
    val veranstalter: String,
    val mail: String,
    val www: String,
    val bemerkungen: String,
    @field:Json(name = "rss_titel") val rssTitel: String,
)
