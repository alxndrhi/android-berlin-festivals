package dev.hinrichs.berlinfestivals.data.repository

import dev.hinrichs.berlinfestivals.data.mapper.toDomain
import dev.hinrichs.berlinfestivals.data.remote.FestivalApi
import dev.hinrichs.berlinfestivals.domain.festival.Festival
import dev.hinrichs.berlinfestivals.domain.repository.FestivalRepository
import java.time.LocalDate
import javax.inject.Inject


class FestivalRepositoryImpl @Inject constructor(
    private val client: FestivalApi
) : FestivalRepository {
    override suspend fun getFestivalData(): List<Festival> {
        return try {
            client.fetchFestivals()
                .festivals
                .filter { it.von.isAfter(LocalDate.now()) || it.bis.isAfter(LocalDate.now()) }
                .sortedBy { it.von }
                .map { it.toDomain() }
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }
}
