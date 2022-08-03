package dev.hinrichs.berlinfestivals.presentation

import dev.hinrichs.berlinfestivals.domain.festival.Festival

data class FestivalState(
    val festivals: List<Festival>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
