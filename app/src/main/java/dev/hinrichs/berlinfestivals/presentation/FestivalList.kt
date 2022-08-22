package dev.hinrichs.berlinfestivals.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.hinrichs.berlinfestivals.domain.festival.Festival

@Composable
fun FestivalList(
    state: FestivalState,
    modifier: Modifier = Modifier
) {
    if (!state.festivals.isNullOrEmpty()) {
        LazyColumn(modifier = modifier) {
            items(state.festivals) { festival ->
                FestivalListItem(festival)
            }
        }
    }
}

@Composable
private fun FestivalListItem(
    festival: Festival
) {
    Column(
        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
    ) {
        Text(text = festival.rssTitel, style = MaterialTheme.typography.h2)
        Text(text = "${festival.start} - ${festival.end}", style = MaterialTheme.typography.body1)
    }
}
