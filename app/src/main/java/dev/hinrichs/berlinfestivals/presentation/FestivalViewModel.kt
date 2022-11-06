package dev.hinrichs.berlinfestivals.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.hinrichs.berlinfestivals.data.Resource
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
            state = when (val result = repository.getFestivalData()) {
                is Resource.Success -> {
                    state.copy(
                        festivals = result.data,
                        isLoading = false,
                        error = null,
                    )
                }
                is Resource.Error -> {
                    state.copy(
                        isLoading = false, error = result.message
                    )
                }
            }
        }
    }
}
