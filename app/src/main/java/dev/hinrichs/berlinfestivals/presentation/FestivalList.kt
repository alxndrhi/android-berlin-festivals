package dev.hinrichs.berlinfestivals.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
    val uriHandler = LocalUriHandler.current

    Column {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(top = 5.dp, bottom = 5.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 10.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                AsyncImage(
                    model = festival.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.CenterStart,
            ) {
                Text(
                    text = festival.rssTitel,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "${festival.startDate} - ${festival.endDate}",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "Webseite",
            style = MaterialTheme.typography.button,
            modifier = Modifier
                .clickable {
                    uriHandler.openUri(festival.contact.website)
                }
        )
    }
}
