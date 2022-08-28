# Berliner Strassenfeste

A playground project for me to learn android development.

The idea is to call Berlins open data portal ([https://daten.berlin.de](https://daten.berlin.de)) and fetch
Information about registered Events / Festivals in Berlin and make these viewable 
within the app.

## Data Source
The data is used for this app is fetched from the open data portal of Berlin
[https://daten.berlin.de/datensaetze/berliner-straßen-und-volksfeste-2022](https://daten.berlin.de/datensaetze/berliner-straßen-und-volksfeste-2022)

## What I want to do / learn:
- __Step 1__ (basics)
  - [x] Basic project setup and structure "for a small project" (data, domain, presentation)
  - [x] fetching data from open data portal (retrofit, dto, domain model, view-model)
  - [x] display data in a simple list (don't care about styling right now)
- __Step 1.1__
  - [x] add linter (ktlint)
  - [x] bump versions
  - [x] add github action to build on push
  - [x] ~~optional~~: find an app icon to use
- __Step 1.2__
  - [x] improve mapper (correct image and website string)
  - [x] load festival images if available in festival list
  - [x] use english names in Dto and use json annotation for fields
- __Step 2__ (theming / styling)
  - [x] show up to 5 current and upcoming festivals styled with image and event name in a row (like featured)
- __Step 3__ (testing)
  - [ ] make festival clickable and show detail info's
  - [ ] add interaction on detail view like: click on phone number to call
  - [ ] add tests to the project (UI, Unit, ...)
- __Step 4__ (show events on map)
  - [ ] add a map that shows selected event on it
  - [ ] click to navigate to it
- __Step 5__ (storage / caching)
  - [ ] sync festival info's on app start and store them local
  - [ ] add like or pin function so you can like/pin festivals
- __more__ (unfiltered, not sorted, optional)
  - [ ] add a share button, to send info about events to others
  - [ ] add notifications for upcoming festivals you pinned or liked
  - [ ] Festival compass: AR open camera and show information (for example festival name and distance) if you look in the direction of the festival
  - [ ] add comment functionality

## Sources
- App layers: [Guide to app architecture](https://developer.android.com/topic/architecture)
- Dagger-Hilt: [Dependency Injection with Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- Retrofit: [Retrofit](https://square.github.io/retrofit/)
- Moshi: [https://github.com/square/moshi](https://github.com/square/moshi)
- Jetpack Compose: [Jetpack Compose Pathway](https://developer.android.com/courses/pathways/compose)
- Coil Image Loading: [Coil Jatpack Compose](https://coil-kt.github.io/coil/compose/)