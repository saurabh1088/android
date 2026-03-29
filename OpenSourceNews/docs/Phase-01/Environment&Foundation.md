# Phase-01 : Environment & Foundation

To initiate the development of **OpenSource News**, the focus begins with the **Foundation Phase**. This stage establishes the structural integrity of the application, ensuring that dependency management and core data models are correctly defined before UI or networking logic is implemented.

---

## Phase 1: Environment & Foundation

### Task 1.1: Project Setup and Dependency Management
The developer opens **Android Studio** and creates a new project using the **Empty Compose Activity** template. The configuration of the `build.gradle` (Module: app) file is the primary objective, ensuring all necessary libraries are integrated.

* **Plugin Setup:** The developer adds the `kotlin-kapt` and `dagger.hilt.android.plugin` to the plugins block to enable annotation processing.
* **Dependency Injection (Hilt):** The developer adds `com.google.dagger:hilt-android` and the corresponding compiler.
* **Networking (Retrofit):** The developer includes `com.squareup.retrofit2:retrofit` and the `converter-gson` for JSON parsing.
* **Local Persistence (Room):** The developer adds `androidx.room:room-runtime`, `androidx.room:room-ktx`, and the `room-compiler`.
* **Image Loading (Coil):** The developer adds `io.coil-kt:coil-compose` for asynchronous image rendering in Compose.

### Task 1.2: Core Data Modeling
The developer defines the internal representation of a news article. This requires creating Kotlin **Data Classes**, which serve a similar purpose to **Structs** in Swift for holding immutable data.

```kotlin
// The Article model representing the news content
data class Article(
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?,
    val source: Source
)

// The Source model identifying the origin of the article
data class Source(
    val id: String?,
    val name: String
)
```

---

## Task 1.3: Understanding the Android Manifest
Unlike iOS, where permissions and app configurations are often handled via `Info.plist`, Android utilizes the `AndroidManifest.xml` file. 

* **Internet Permission:** The developer must explicitly declare `<uses-permission android:name="android.permission.INTERNET" />` to allow the app to make network requests.
* **Application Class:** The developer creates a class inheriting from `Application` and annotates it with `@HiltAndroidApp`. This serves as the entry point for dependency injection, similar to the `AppDelegate` or `@main` App struct in SwiftUI.



---
