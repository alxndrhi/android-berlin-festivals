package dev.hinrichs.berlinfestivals.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.hinrichs.berlinfestivals.presentation.ui.theme.BerlinFestivalsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: FestivalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BerlinFestivalsTheme {
                FestivalView(viewModel = viewModel)
            }
        }
    }
}
