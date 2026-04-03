# Open Source News : Requirements

Transitioning from iOS to Android development allows for a comparative analysis of mobile architectures. To leverage professional experience with **SwiftUI** and **Combine**, the following project is designed to utilize the modern Android ecosystem.

---

## Project Overview: "Open Source News"
A high-performance news reader that fetches articles from a public API, allows for offline bookmarking, and supports a "Read Later" feature using local storage.

### Tech Stack (All Free)
* **Language:** Kotlin
* **UI:** Jetpack Compose (Declarative UI)
* **Asynchronous Logic:** Coroutines & Flow
* **Networking:** Retrofit + OkHttp
* **Local Database:** Room (SQLite abstraction)
* **Dependency Injection:** Hilt 
* **Architecture:** Clean Architecture with MVVM
* **API:** [NewsAPI.org](https://newsapi.org/) (Free Developer Tier)

---

## 1. Project Requirements

### Functional Requirements
* The application displays a paginated list of top headlines from various categories.
* The application allows for searching specific topics.
* The application enables saving articles for offline reading.
* The application provides a detail view for each article using a WebView or Chrome Custom Tab.
* The application persists "Saved" articles across process deaths or restarts.

### Learning Objectives
* Mastering **Activity** and **Fragment** lifecycles in contrast to iOS View Controllers.
* Understanding **Jetpack Compose** state management (`remember`, `mutableStateOf`).
* Implementing **Navigation Compose** for type-safe screen transitions.
* Using **Room Database** for local persistence.
* Handling background tasks with **Coroutines**.

---

## 2. Implementation Tasks
The project is structured into incremental milestones to ensure a logical learning path.

### Phase 1: Environment & Foundation
* **Task 1.1:** The developer sets up Android Studio, creates a new "Empty Compose Activity" project, and configures the `build.gradle` files with dependencies for Hilt, Retrofit, and Room.
* **Task 1.2:** The developer defines the `Article` and `Source` data models using Kotlin Data Classes.

### Phase 2: Networking & UI Basics
* **Task 2.1:** The developer implements the **Retrofit** interface to fetch data from the News API.
* **Task 2.2:** The developer creates a `NewsViewModel` that uses **StateFlow** to expose the API response to the UI.
* **Task 2.3:** The developer builds a `NewsItem` composable to display an article's image, title, and description using the **Coil** library for image loading.

### Phase 3: Local Persistence
* **Task 3.1:** The developer sets up **Room** by defining an `@Entity`, a `Dao` (Data Access Object), and a `RoomDatabase` class.
* **Task 3.2:** The developer implements a repository pattern to toggle between the Network and the Local Database.
* **Task 3.3:** The developer adds a "Bookmark" button to each news item that saves the article to the local SQLite database.

### Phase 4: Dependency Injection & Navigation
* **Task 4.1:** The developer integrates **Hilt** to provide the Repository and Database instances throughout the app.
* **Task 4.2:** The developer implements **Jetpack Navigation** to manage transitions from the "Home" list to an "Article Detail" screen.
* **Task 4.3:** The developer implements a **BottomNavigationView** to switch between "Top Headlines" and "Saved Articles."

### Phase 5: Advanced Concepts
* **Task 5.1:** The developer implements the **Paging 3** library to handle infinite scrolling for the news feed.
* **Task 5.2:** The developer adds a "Dark Mode" toggle using Compose `MaterialTheme` overrides.

---
