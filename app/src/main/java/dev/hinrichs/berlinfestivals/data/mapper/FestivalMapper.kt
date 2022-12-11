package dev.hinrichs.berlinfestivals.data.mapper

import dev.hinrichs.berlinfestivals.data.remote.FestivalDto
import dev.hinrichs.berlinfestivals.domain.festival.Festival
import dev.hinrichs.berlinfestivals.domain.festival.FestivalContact

fun FestivalDto.toDomain() = Festival(
    id = this.id.toInt(),
    imageUrl = buildImageUrl(this.imagePath),
    copyright = this.copyright,
    description = this.description,
    district = this.district,
    street = this.street,
    zipCode = this.zip,
    startDate = this.startDate,
    endDate = this.endDate,
    openingHours = this.openingHours,
    contact = FestivalContact(
        organizer = this.organizer,
        email = this.email,
        website = naiveUrlPatcher(this.website),
    ),
    info = this.info,
    rssTitel = this.rssTitel,
)

private fun buildImageUrl(imagePath: String): String {
    return if (imagePath.isNotEmpty()) {
        "https://bsfdemoinfrastack-bsf2022demobucket8f0601d7-cvq3v93snnnh.s3.eu-central-1.amazonaws.com/images/${imagePath.split('/').last()}"
    } else { "" }
}

/**
 * Will naively add https to given strings, that miss the protocol at the beginning.
 * It will not check if the url is actually https or only http nor if the given string actually is an url.
 */
private fun naiveUrlPatcher(website: String): String {
    return if (website.isNotEmpty() && !website.startsWith("http")) {
        "https://$website"
    } else {
        website
    }
}
