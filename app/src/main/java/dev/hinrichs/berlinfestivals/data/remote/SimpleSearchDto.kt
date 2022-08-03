package dev.hinrichs.berlinfestivals.data.remote

import com.squareup.moshi.Json

data class SimpleSearchDto(
    @field:Json(name = "index")
    val festivals: List<FestivalDto>
)
