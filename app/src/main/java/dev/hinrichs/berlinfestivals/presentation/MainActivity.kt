package dev.hinrichs.berlinfestivals.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import dagger.hilt.android.AndroidEntryPoint
import dev.hinrichs.berlinfestivals.presentation.ui.theme.BerlinFestivalsTheme
import dev.hinrichs.berlinfestivals.presentation.ui.theme.darker

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: FestivalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BerlinFestivalsTheme {
                SetStatusBarColor()
                FestivalView(viewModel = viewModel)
            }
        }
    }

    @Composable
    private fun SetStatusBarColor() {
        window?.statusBarColor = MaterialTheme
            .colors
            .background
            .darker(.2f)
            .toArgb()
    }
}
