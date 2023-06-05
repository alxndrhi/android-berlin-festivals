package dev.hinrichs.berlinfestivals

import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.hinrichs.berlinfestivals.data.remote.FestivalApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.time.LocalDate
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesFestivalApi(): FestivalApi {
        return Retrofit.Builder()
            .baseUrl("https://www.berlin.de/sen/web/service/maerkte-feste/strassen-volksfeste/index.php/index/")
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(LocalDateAdapter())
                        .build()
                )
            )
            .build()
            .create()
    }

    private class LocalDateAdapter() {
        @ToJson
        fun toJson(date: LocalDate): String = date.toString()

        @FromJson
        fun fromJson(date: String): LocalDate = LocalDate.parse(date)
    }
}
