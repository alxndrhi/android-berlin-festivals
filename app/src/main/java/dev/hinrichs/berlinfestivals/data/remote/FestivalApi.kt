package dev.hinrichs.berlinfestivals.data.remote

import retrofit2.http.GET

interface FestivalApi {
    @GET("all.json?q=")
    suspend fun fetchFestivals(): SimpleSearchDto
}
