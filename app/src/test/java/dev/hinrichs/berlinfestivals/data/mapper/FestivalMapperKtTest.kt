package dev.hinrichs.berlinfestivals.data.mapper

import dev.hinrichs.berlinfestivals.data.remote.FestivalDto
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import java.time.LocalDate

class FestivalMapperKtTest {

    @Test
    internal fun `should add http to domain object when mapped`() {
        val sourceDto = aFestivalDto()
        val result = sourceDto.toDomain()

        assertThat(
            result.contact.website.substring(0..3),
            equalTo("http")
        )
        assertThat(
            result.contact.website,
            containsString(sourceDto.website)
        )
    }

    @Test
    internal fun `should create image url from image path`() {
        val sourceDto = aFestivalDto()
        val result = sourceDto.toDomain()

        assertThat(
            result.imageUrl.substring(0..3),
            equalTo("http")
        )
        assertThat(
            result.imageUrl,
            containsString(sourceDto.imagePath.split("/").last())
        )
    }

    private fun aFestivalDto(
        id: String = "240",
        imagePath: String = "/strassen-volksfeste/assets/biermarkt.jpg",
        copyright: String = "Some Copyright",
        district: String = "Treptow-Köpenick",
        description: String = "Biermarkt",
        street: String = "Bierwiese",
        zip: String = "12345",
        startDate: LocalDate = LocalDate.parse("2022-07-29"),
        endDate: LocalDate = LocalDate.parse("2022-07-31"),
        openingHours: String = "",
        organizer: String = "Bierwiese Entertainment, Tel.: 01234567, Fax: 01234568, Mobil 01234569",
        email: String = "testing+random@test.dev",
        website: String = "www.test.dev",
        info: String = "Eintritt 2 Euro",
        rssTitel: String = "Biermarkt"
    ) = FestivalDto(
        id = id,
        imagePath = imagePath,
        copyright = copyright,
        district = district,
        description = description,
        street = street,
        zip = zip,
        startDate = startDate,
        endDate = endDate,
        openingHours = openingHours,
        organizer = organizer,
        email = email,
        website = website,
        info = info,
        rssTitel = rssTitel,
    )
}
