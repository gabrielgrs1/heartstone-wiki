# Android Heartstone Wiki

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.7.x-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AGP-7.x-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-7.x-blue?style=flat)](https://gradle.org)

[![CodeBeat Badge](https://codebeat.co/badges/0872549a-6e75-41f5-ac43-e33b6bab14a1)](https://codebeat.co/projects/github-com-gabrielgrs1-heartstone-wiki-master)
[![CodeFactor](https://www.codefactor.io/repository/github/gabrielgrs1/heartstone-wiki/badge)](https://www.codefactor.io/repository/github/gabrielgrs1/heartstone-wiki)
[![Build Status](https://github.com/gabrielgrs1/heartstone-wiki/workflows/Push%20&%20Pull%20Request%20Pipe/badge.svg)](https://github.com/gabrielgrs1/heartstone-wiki/actions)
[![codecov.io](https://codecov.io/github/gabrielgrs1/heartstone-wiki/branch/master/graph/badge.svg)](https://codecov.io/github/gabrielgrs1/heartstone-wiki)

Android HeartStone Wiki project presents a modern approach to
[Android](https://en.wikipedia.org/wiki/Android_(operating_system)) application development. This project utilizes
popular tools, libraries, linters, Gradle plugins, testing frameworks, and CI setup. It is a complete sample of a fully
functional Android application.

Project is focusing on modular, scalable, maintainable, and testable [architecture](#architecture), leading
[tech-stack](#tech-stack) and demonstrates the best development practices.

This application may look simple, but it has all of the pieces that will provide the rock-solid foundation for the
larger application suitable for bigger teams and extended
[application lifecycle](https://en.wikipedia.org/wiki/Application_lifecycle_management).

- [Android HeartStone Wiki](#android-heartstone-wiki)
  - [Application Scope](#application-scope)
  - [Tech-Stack](#tech-stack)
  - [Architecture](#architecture)
    - [Module Types And Module Dependencies](#module-types-and-module-dependencies)
    - [Feature Module Structure](#feature-module-structure)
    - [Presentation Layer](#presentation-layer)
    - [Domain Layer](#domain-layer)
    - [Data Layer](#data-layer)
    - [Data Flow](#data-flow)
  - [Dependency Management](#dependency-management)
  - [Logcat debuggins](#logcat-debuggins)
  - [CI Pipeline](#ci-pipeline)
    - [Pull Request Verification](#pull-request-verification)
  - [Getting Started](#getting-started)
    - [Android Studio](#android-studio)
    - [Command-line And Android Studio](#command-line-and-android-studio)
    - [Plugins](#plugins)

## Application Scope

The `android-hearstone-wiki` displays information about [heartstone](https://hearthstone.blizzard.com/pt-br) cards. The data is loaded from the
[HearStone Api](https://rapidapi.com/omgvamp/api/hearthstone).

The app has a few screens located in multiple feature modules:

- Card list screen - displays list of card
- Card detail screen - display information about the selected card
  <br/>
  
<p float="center">
  <img src="images/card-list.png" width="250" />
  <img src="images/card-detail-1.png" width="250" />
  <img src="images/card-detail-2.png" width="250" />
</p>

## Tech-Stack

This project takes advantage of best practices, and many popular libraries and tools in the Android ecosystem. Most of
the libraries are in the stable version unless there is a good reason to use non-stable dependency.

* Tech-stack
  * [100% Kotlin](https://kotlinlang.org/)
    + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
    + [Kotlin Symbol Processing](https://kotlinlang.org/docs/ksp-overview.html) - enable compiler plugins
  * [Retrofit](https://square.github.io/retrofit/) - networking
  * [GSON Serialization](https://github.com/google/gson)
  * [Jetpack](https://developer.android.com/jetpack)
    * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - in-app navigation
    * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when
      lifecycle state changes
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related
      data in a lifecycle-aware way
    * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata?hl=pt-br)
  * [Koin](https://insert-koin.io/) - dependency injection (dependency retrieval)
  * [Picasso](https://github.com/square/picasso) - image loading library
* Modern Architecture
  * [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
  * Single activity architecture
    using [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started)
  * MVVM (presentation layer)
  * [Android Architecture components](https://developer.android.com/topic/libraries/architecture)
    ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    , [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation))
  * [Android KTX](https://developer.android.com/kotlin/ktx) - Jetpack Kotlin extensions
* UI
  * Reactive UI
  * [View Binding](https://developer.android.com/topic/libraries/view-binding) - retrieve xml view ids
    (used for [NavHostActivity](app/src/main/java/com/igorwojda/showcase/app/presentation/NavHostActivity.kt) only)
  * [Material Design 3](https://m3.material.io/) - application design system providing UI components
* CI
  * [GitHub Actions](https://github.com/features/actions)
  * Automatic PR verification including tests, linters, and 3rd online tools
* Testing
  * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit 5](https://junit.org/junit5/) via
    [android-junit5](https://github.com/mannodermaus/android-junit5)) - test individual classes
  * [Mockk](https://mockk.io/) - mocking framework
  * [Kluent](https://github.com/MarkusAmshove/Kluent) - assertion framework
* Static analysis tools (linters)
  * [Ktlint](https://github.com/pinterest/ktlint) - verify code formatting
  * [Detekt](https://github.com/arturbosch/detekt#with-gradle) - verify code complexity and code smells
  * [Android Lint](http://tools.android.com/tips/lint) - verify Android platform usage
* Gradle
  * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - define build scripts
  * Custom tasks
  * [Gradle Plugins](https://plugins.gradle.org/)
    * [Android Gradle](https://developer.android.com/studio/releases/gradle-plugin) - standard Android Plugins
    * [Test Logger](https://github.com/radarsh/gradle-test-logger-plugin) - format test logs
    * [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) - pass data between
      navigation destinations
    * [Android-junit5](https://github.com/mannodermaus/android-junit5) - use [JUnit 5](https://junit.org/junit5/) with Android
  * [Versions catalog](https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog) - define dependencies
  * [Type safe accessors](https://docs.gradle.org/7.0/release-notes.html)

## Architecture

By dividing a problem into smaller and easier to solve sub-problems, we can reduce the complexity of designing and
maintaining a large system. Each module is independent build-block serving a clear purpose. We can think about each
feature as the reusable component, equivalent of [microservice](https://en.wikipedia.org/wiki/Microservices) or private
library.

The modularized code-base approach provides a few benefits:

- reusability - enable code sharing and building multiple apps from the same foundation. Apps should be a sum of their
- features where the features are organized as separate modules.
- features can be developed in parallel eg. by different teams
- each feature can be developed in isolation, independently from other features
- faster build time

### Module Types And Module Dependencies

This diagram presents dependencies between project modules (Gradle sub-projects).

We have three kinds of modules in the application:

- `app` module - this is the main module. It contains code that wires multiple modules together (class, dependency
  injection setup, `NavHostActivity`, etc.) and fundamental application configuration (retrofit configuration, required
  permissions setup, custom `Application` class, etc.).
- `feature_x` modules - the most common type of module containing all code related to a given feature.
  share some assets or code only between `feature` modules (currently app has no such modules)
- `feature_base` modules that features modules depend on to share a common code.

### Feature Module Structure

`Clean Architecture` is implemented at module level - each module contains its own set of Clean Architecture layers:

<p float="center">
  <img src="images/feature_module_structure.png" width="250" />
</p>

> Notice that the `app` module and `library_x` modules structure differs a bit from the feature module structure.

Each feature module contains non-layer components and 3 layers with a distinct set of responsibilities.

<p float="center">
  <img src="images/feature_module_layers.png" width="250" />
</p>

#### Presentation Layer

This layer is closest to what the user sees on the screen.

The `presentation` layer mixes `MVVM` patterns:

- `MVVM` - Jetpack `ViewModel` is used to encapsulate `common UI state`. It exposes the `state` via observable state
  holder (`Live Data`)


Components:

- **View (Fragment)** - observes common view state (through `LiveData`). Pass user
  interactions to `ViewModel`. Views are hard to test, so they should be as simple as possible.
- **ViewModel** - emits (through `LiveData`) view state changes to the view and deals with user interactions.
- **ViewState** - common state for a single view
- **StateTimeTravelDebugger** - logs actions and view state transitions to facilitate debugging.
- **NavManager** - singleton that facilitates handling all navigation events inside `NavHostActivity` (instead of
  separately, inside each view)

#### Domain Layer

This is the core layer of the application. Notice that the `domain` layer is independent of any other layers. This
allows making domain models and business logic independent from other layers. In other words, changes in other layers
will not affect `domain` layer eg. changing the database (`data` layer) or screen UI (`presentation` layer) ideally will
not result in any code change withing the `domain` layer.

Components:

- **UseCase** - contains business logic
- **DomainModel** - defines the core structure of the data that will be used within the application. This is the source
  of truth for application data.
- **Repository interface** - required to keep the `domain` layer independent from
  the `data layer` ([Dependency inversion](https://en.wikipedia.org/wiki/Dependency_inversion_principle)).

#### Data Layer

Manages application data. Connect to data sources and provide data through repository to the `domain` layer eg. retrieve
data from the internet and cache the data in disk cache (when device is offline).

Components:

- **Repository** is exposing data to the `domain` layer. Depending on the application structure and quality of the
  external APIs repository can also merge, filter, and transform the data. These operations intend to create
  high-quality data source for the `domain` layer.
- **Mapper** - maps `data model` to `domain model` (to keep `domain` layer independent from the `data` layer).

Data layer contains implicit layer called `Data source` containing all components involved with data manipulation of a
given data source. Application has two data sources - `Retrofit` (network) and `Room` (local storage):

- **Retrofit Service** - defines a set of API endpoints
- **Retrofit Response Model** - definition of the network objects for given endpoint (top-level model for the data
  consists of `ApiModels`)
- **Retrofit Api Data Model** - defines the network objects (sub-objects of the `Response Model`)

Both `Retrofit API Data Models` contain annotations, so given framework understands how to parse the
data into objects.

### Data Flow

The below diagram presents application data flow when a user interacts with the `card list screen`:

<!--- Upload diagram image -->

## Dependency Management

Gradle [versions catalog](https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog) is used as a
centralized dependency management third-party dependency coordinates (group, artifact, version) are shared across all
modules (Gradle projects and subprojects).

Each feature module depends on the `feature_base` module, so dependencies are shared without the need to add them
explicitly in each feature module.

## Logcat debuggins

To facilitate debuting project contains logs. You can filter logs understand app flow. Keywords:
- `onCreate` see what `Activities` and `Fragements` have been created
- `Action` - filter all actions performed on the screens to update the UI
- `Http` - debug network requests and responses

## CI Pipeline

CI is utilizing [GitHub Actions](https://github.com/features/actions). Complete GitHub Actions config is located in
the [.github/workflows](.github/workflows) folder.

### Pull Request Verification

Series of workflows run (in parallel) for every opened PR and after merging PR to the `master` branch:

* `./gradlew lintDebug` - runs Android lint
* `./gradlew detektCheck` - runs detekt and ktlint
* `./gradlew testDebugUnitTest` - run unit tests
* `./gradlew connectedCheck` - run UI tests
* `./gradlew :app:bundleDebug` - create app bundle

## Getting Started

There are a few ways to open this project.

### Android Studio

1. `Android Studio` -> `File` -> `New` -> `From Version control` -> `Git`
2. Enter `https://github.com/gabrielgrs1/heartstone-wiki.git` into URL field and press `Clone` button
3. Enter [HeartStone Wiki Api](https://rapidapi.com/omgvamp/api/hearthstone) and get api key
4. Input apiKey on `apiToken` variable on `local.properties`

## Inspiration

[Android Showcase](https://github.com/igorwojda/android-showcase)
