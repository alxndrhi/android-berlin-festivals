package dev.hinrichs.berlinfestivals.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import dev.hinrichs.berlinfestivals.presentation.ui.theme.BerlinFestivalsTheme
import dev.hinrichs.berlinfestivals.presentation.ui.theme.darker

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: FestivalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadFestivals()

        setContent {
            BerlinFestivalsTheme {
                setStatusBarColor()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        ) {
                            Text(
                                text = "Berliner Straßenfeste",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = MaterialTheme.typography.h4,
                            )
                            FestivalList(state = viewModel.state)
                        }
                        viewModel.state.error?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun setStatusBarColor() {
        window?.statusBarColor = MaterialTheme
            .colors
            .background
            .darker(.8f)
            .toArgb()
    }
}
