package dev.hinrichs.berlinfestivals.data.repository

import dev.hinrichs.berlinfestivals.data.Resource
import dev.hinrichs.berlinfestivals.data.mapper.toDomain
import dev.hinrichs.berlinfestivals.data.remote.FestivalApi
import dev.hinrichs.berlinfestivals.domain.festival.Festival
import dev.hinrichs.berlinfestivals.domain.repository.FestivalRepository
import javax.inject.Inject

class FestivalRepositoryImpl @Inject constructor(
    private val client: FestivalApi
) : FestivalRepository {
    override suspend fun getFestivalData(): Resource<List<Festival>> {
        return try {
            Resource.Success(
                data = client.fetchFestivals().festivals
                    .sortedBy { it.startDate }
                    .map { it.toDomain() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "unknown error")
        }
    }
}
