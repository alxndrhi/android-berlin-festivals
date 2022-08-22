package dev.hinrichs.berlinfestivals

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.hinrichs.berlinfestivals.data.repository.FestivalRepositoryImpl
import dev.hinrichs.berlinfestivals.domain.repository.FestivalRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindFestivalRepository(
        festivalRepositoryImpl: FestivalRepositoryImpl
    ): FestivalRepository
}
