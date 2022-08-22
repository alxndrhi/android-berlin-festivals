package dev.hinrichs.berlinfestivals.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.hinrichs.berlinfestivals.domain.repository.FestivalRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FestivalViewModel @Inject constructor(
    private val repository: FestivalRepository,
) : ViewModel() {

    var state by mutableStateOf(FestivalState())
        private set

    init {
        this.loadFestivals()
    }

    fun loadFestivals() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null,
            )
            state = try {
                val result = repository.getFestivalData()
                state.copy(
                    festivals = result,
                    isLoading = false,
                    error = null,
                )
            } catch (e: Exception) {
                state.copy(
                    isLoading = false,
                    error = "${e.message}"
                )
            }
        }
    }
}
