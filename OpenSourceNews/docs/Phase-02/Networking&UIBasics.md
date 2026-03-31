# Phase-02 : Networking & UI Basics

Moving into **Phase 2**, the objective is to establish the communication layer between the application and the external News API. This phase introduces **Retrofit**, which is the industry standard for networking in Android, serving a similar purpose to **URLSession** or **Alamofire** in the iOS ecosystem.

---

## Task 2.1: Implementing the Retrofit Interface

In Android, networking is typically defined using a simple Java/Kotlin interface. The developer does not write the implementation logic for the HTTP requests; instead, **Retrofit** generates the implementation at runtime based on annotations.

### 1. Creating the Response Wrapper
The News API returns articles wrapped in a JSON object containing metadata (like `status` and `totalResults`). The developer must create a "Response" data class to match this structure.

**File:** `data/model/NewsResponse.kt`
```kotlin
package com.opensource.news.data.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
```

### 2. Defining the API Service
The developer creates an interface to define the available endpoints. This is where HTTP methods (GET, POST, etc.) and URL paths are specified.

**File:** `data/network/NewsApiService.kt`
```kotlin
package com.opensource.news.data.network

import com.opensource.news.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = "YOUR_API_KEY_HERE"
    ): NewsResponse
}
```

* **`suspend` keyword:** This marks the function as a **Coroutine**, allowing it to be called without blocking the main UI thread. It is conceptually similar to `async` in Swift.
* **`@Query`:** This automatically appends parameters to the URL (e.g., `?country=us&apiKey=...`).

---

## Task 2.2: The ViewModel and StateFlow

In modern Android development, the **ViewModel** is responsible for holding the UI state and communicating with the data layer. To expose data to **Jetpack Compose**, the developer uses **StateFlow** (similar to a `@Published` property in SwiftUI or an `ObservableObject`).

### 1. Defining the UI State
The developer creates a "Sealed Class" to represent the different states of the screen (Loading, Success, or Error). This ensures the UI is a direct reflection of the data state.

**File:** `ui/NewsUiState.kt`
```kotlin
sealed class NewsUiState {
    object Loading : NewsUiState()
    data class Success(val articles: List<Article>) : NewsUiState()
    data class Error(val message: String) : NewsUiState()
}
```

### 2. Implementing the ViewModel
The ViewModel triggers the network request and updates the state.

**File:** `ui/NewsViewModel.kt`
```kotlin
class NewsViewModel(private val apiService: NewsApiService) : ViewModel() {

    private val _uiState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val uiState: StateFlow<NewsUiState> = _uiState

    fun fetchNews() {
        viewModelScope.launch {
            try {
                val response = apiService.getTopHeadlines()
                _uiState.value = NewsUiState.Success(response.articles)
            } catch (e: Exception) {
                _uiState.value = NewsUiState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}
```



---

## Comparison for the iOS Developer
* **Networking:** In iOS, a developer might use `JSONDecoder().decode()`. In Android, Retrofit handles the decoding automatically using the **GsonConverterFactory** configured during setup.
* **Concurrency:** Instead of `DispatchQueue.main.async`, Android uses **Coroutines** with `viewModelScope`. This ensures that if the user navigates away from the screen, the network request is automatically cancelled, preventing memory leaks.

---
