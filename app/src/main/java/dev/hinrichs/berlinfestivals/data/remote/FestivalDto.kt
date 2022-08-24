package dev.hinrichs.berlinfestivals.data.remote

import com.squareup.moshi.Json
import java.time.LocalDate

data class FestivalDto(
    val id: String,
    @field:Json(name = "bild") val imagePath: String,
    val copyright: String,
    @field:Json(name = "bezirk") val district: String,
    @field:Json(name = "bezeichnung") val description: String,
    @field:Json(name = "strasse") val street: String,
    @field:Json(name = "plz") val zip: String,
    @field:Json(name = "von") val startDate: LocalDate,
    @field:Json(name = "bis") val endDate: LocalDate,
    @field:Json(name = "zeit") val openingHours: String,
    @field:Json(name = "veranstalter") val organizer: String,
    @field:Json(name = "mail") val email: String,
    @field:Json(name = "www") val website: String,
    @field:Json(name = "bemerkungen") val info: String,
    @field:Json(name = "rss_titel") val rssTitel: String,
)
