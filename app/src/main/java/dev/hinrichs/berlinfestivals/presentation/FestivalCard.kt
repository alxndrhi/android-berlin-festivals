package dev.hinrichs.berlinfestivals.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.hinrichs.berlinfestivals.domain.festival.Festival
import dev.hinrichs.berlinfestivals.domain.festival.FestivalContact
import java.time.LocalDate

@Composable
fun FestivalCards(
    state: FestivalState,
    modifier: Modifier = Modifier
) {
    val nextFestivalsWithImage = state.festivals
        ?.filter { it.imageUrl.isNotEmpty() && it.contact.website.isNotEmpty() }
        ?.take(5)
    if (!nextFestivalsWithImage.isNullOrEmpty()) {
        LazyRow(
            modifier = modifier.padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(nextFestivalsWithImage) { festival ->
                FestivalCard(festival = festival, modifier = modifier)
            }
        }
    }
}

@Composable
fun FestivalCard(
    festival: Festival,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = modifier
            .width(150.dp)
            .height(250.dp)
            .clickable {
                uriHandler.openUri(festival.contact.website)
            },
        shape = MaterialTheme.shapes.small,
    ) {
        AsyncImage(
            model = festival.imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
        )
        Column(
            modifier = modifier
                .padding(10.dp)
        ) {
            Text(
                modifier = modifier.background(color = Color.Gray.copy(alpha = .6f)),
                text = festival.rssTitel,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold, color = MaterialTheme.colors.onPrimary,
            )
        }
    }
}

@Preview
@Composable
fun FestivalCardPreview() {
    FestivalCard(
        Festival(
            id = 0,
            imageUrl = "https://placeimg.com/640/360/anomals",
            copyright = "Copyright Info",
            description = "Demo Fest",
            district = "Mitte",
            street = "Leipziger Strasse 110",
            zipCode = "10117",
            startDate = LocalDate.now(),
            endDate = LocalDate.now().plusDays(14),
            openingHours = "10:00 - 21:00",
            contact = FestivalContact(
                organizer = "Demo Organizer",
                email = "alexander@hinrichs.dev",
                website = "https://www.hinrichs.dev"
            ),
            info = "Info zum Fest",
            rssTitel = "Demo Fest Titel"
        )
    )
}
