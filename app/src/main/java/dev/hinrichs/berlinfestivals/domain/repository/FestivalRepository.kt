package dev.hinrichs.berlinfestivals.domain.repository

import dev.hinrichs.berlinfestivals.data.Resource
import dev.hinrichs.berlinfestivals.domain.festival.Festival

interface FestivalRepository {
    suspend fun getFestivalData(): Resource<List<Festival>>
}
