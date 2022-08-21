package dev.hinrichs.berlinfestivals.presentation.ui.theme

import androidx.compose.ui.graphics.Color
import kotlin.math.max

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


fun Color.darker(factor: Float): Color {
    return Color(
        red = max(this.red.times(factor), 0f),
        green = max(this.green.times(factor), 0f),
        blue = max(this.blue.times(factor), 0f),
        alpha = this.alpha
    )
}

