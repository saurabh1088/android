# Phase-04 : Dependency Injection & Navigation

In **Phase 4**, the architecture is finalized by connecting the independent layers (Networking, Database, and UI) using **Hilt** and establishing a flow between screens using **Jetpack Navigation**.

---

## Task 4.1: Dependency Injection with Hilt
In iOS, dependency injection is often handled manually or via frameworks like Swinject. In Android, **Hilt** (built on Dagger) is the standard. It automates the creation and "injection" of objects so the developer doesn't have to instantiate the Database or API service manually in every ViewModel.

The developer creates a **Module** to tell Hilt how to provide these dependencies.

**File:** `di/AppModule.kt`
```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApiService(): NewsApiService {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            "news_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApiService, db: NewsDatabase): NewsRepository {
        return NewsRepository(api, db.getArticleDao())
    }
}
```



---

## Task 4.2: Jetpack Navigation
Android navigation has shifted from Intent-based Activity switching to a **Single Activity Architecture**. Navigation is now handled by a `NavHost` that swaps **Composables** (screens) in and out, similar to how `NavigationStack` works in SwiftUI.

The developer defines the routes as a sealed class or a type-safe object.

**File:** `ui/navigation/Screen.kt`
```kotlin
sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object ArticleDetail : Screen("detail_screen")
    object Saved : Screen("saved_screen")
}
```

**Implementation in `MainActivity.kt`:**
The developer sets up the `NavHost` to listen for route changes.

```kotlin
@Composable
fun NewsNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.ArticleDetail.route) { ArticleDetailScreen() }
        composable(Screen.Saved.route) { SavedScreen(navController) }
    }
}
```

---

## Task 4.3: Bottom Navigation
To allow the user to switch between the "Feed" and "Bookmarks," the developer implements a **Scaffold**. This is the Android equivalent of a `TabView` in SwiftUI, providing a standard layout structure.

**File:** `ui/MainScreen.kt`
```kotlin
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                // Implementation of navigation items for Home and Saved
            }
        }
    ) { paddingValues ->
        // NavHost goes here with applied padding
    }
}
```

---

## PR Title: feat: Integrate Hilt DI and Jetpack Navigation

### Summary
The developer has established the application's "wiring" and navigation flow.

### Changes
* **Dependency Injection:** Implemented `AppModule` to provide Singleton instances of Retrofit, Room, and the Repository.
* **Navigation Graph:** Set up `Navigation Compose` to handle transitions between the news feed, article details, and saved bookmarks.
* **Architecture Refinement:** Updated `NewsViewModel` to use `@HiltViewModel`, allowing it to receive the `NewsRepository` automatically through its constructor.

---

### Comparison for the iOS Developer
* **DI:** Hilt is more "magical" than Swinject; by using `@Inject`, the developer avoids passing dependencies through several initializers.
* **Navigation:** `NavHost` functions very similarly to a programmatic `NavigationStack` where routes are defined by strings or objects, and state is maintained within the `NavController`.
