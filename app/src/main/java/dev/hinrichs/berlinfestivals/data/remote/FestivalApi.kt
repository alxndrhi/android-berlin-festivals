package dev.hinrichs.berlinfestivals.data.remote

import retrofit2.http.GET

interface FestivalApi {
    @GET("sen/web/service/maerkte-feste/strassen-volksfeste/index.php/index/all.json?q=")
    suspend fun fetchFestivals(): SimpleSearchDto
}
