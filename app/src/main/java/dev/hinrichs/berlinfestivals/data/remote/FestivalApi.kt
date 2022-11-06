package dev.hinrichs.berlinfestivals.data.remote

import retrofit2.http.GET

interface FestivalApi {
    @GET("/festivals.json")
    suspend fun fetchFestivals(): SimpleSearchDto
}
