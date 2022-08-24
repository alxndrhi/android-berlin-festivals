package dev.hinrichs.berlinfestivals.domain.festival

import com.squareup.moshi.Json
import java.time.LocalDate

data class Festival(
    val id: Int,
    val imageUrl: String,
    val copyright: String,
    val description: String,
    val district: String,
    val street: String,
    val zipCode: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val openingHours: String,
    val contact: FestivalContact,
    val info: String,
    @field:Json(name = "rss_titel") val rssTitel: String,
)
