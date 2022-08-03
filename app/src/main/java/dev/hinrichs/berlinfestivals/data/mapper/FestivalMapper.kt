package dev.hinrichs.berlinfestivals.data.mapper

import dev.hinrichs.berlinfestivals.data.remote.FestivalDto
import dev.hinrichs.berlinfestivals.domain.festival.Festival
import dev.hinrichs.berlinfestivals.domain.festival.FestivalContact

fun FestivalDto.toDomain() = Festival(
    id = this.id.toInt(),
    image = this.bild,
    copyright = this.copyright,
    description = this.bezeichnung,
    district = this.bezirk,
    street = this.strasse,
    zipCode = this.plz,
    start = this.von,
    end = this.bis,
    opens = this.zeit,
    contact = FestivalContact(
        organizer = this.veranstalter,
        email = this.mail,
        www = this.www,
    ),
    info = this.bemerkungen,
    rssTitel = this.rssTitel,
)
