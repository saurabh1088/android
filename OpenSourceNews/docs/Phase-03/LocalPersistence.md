# Phase-03 : Local Persistence


In **Phase 3**, the focus shifts to **Local Persistence**. In the iOS world, this is where a developer would typically reach for **Core Data** or **SwiftData**. In Android, the standard is **Room**, a robust abstraction layer over **SQLite** that provides compile-time checks for SQL queries.

---

## Task 3.1: Defining the Room Entity and DAO

The developer must first transform the existing `Article` data class into a database table and define the interface for interacting with that data.

### 1. The Entity (The Table)
To save an `Article` to a local database, it must be annotated with `@Entity`. The developer also needs to specify a **Primary Key**. Since a URL is unique to a news story, it serves as a reliable identifier.

**File:** `data/local/entity/ArticleEntity.kt`
```kotlin
@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey val url: String,
    val title: String,
    val description: String?,
    val urlToImage: String?,
    val publishedAt: String,
    val sourceName: String // Room cannot store custom objects like 'Source' without a Converter
)
```

### 2. The DAO (Data Access Object)
The DAO is an interface that defines the CRUD (Create, Read, Update, Delete) operations. This is where the developer writes the SQL queries.

**File:** `data/local/dao/ArticleDao.kt`
```kotlin
@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: ArticleEntity)

    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Delete
    suspend fun deleteArticle(article: ArticleEntity)
}
```
* **`upsert`:** A combination of "Update" and "Insert." If the article exists, it updates; otherwise, it inserts.
* **`Flow<List<...>>`:** By returning a **Flow**, Room automatically notifies the UI whenever the database content changes, acting similarly to a `@FetchRequest` in SwiftUI.

---

## Task 3.2: Setting up the Room Database

The developer creates an abstract class that extends `RoomDatabase`. This class serves as the main connection point to the SQLite data.

**File:** `data/local/NewsDatabase.kt`
```kotlin
@Database(entities = [ArticleEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
}
```

---

## Task 3.3: The Repository Pattern

To keep the code clean and testable, the developer implements a **Repository**. This class decides whether to fetch data from the Network (Phase 2) or the Local Database (Phase 3). 



**File:** `data/repository/NewsRepository.kt`
```kotlin
class NewsRepository(
    private val apiService: NewsApiService,
    private val articleDao: ArticleDao
) {
    suspend fun getRemoteNews() = apiService.getTopHeadlines()

    suspend fun saveArticle(article: ArticleEntity) = articleDao.upsert(article)

    fun getSavedNews() = articleDao.getAllArticles()

    suspend fun deleteSavedArticle(article: ArticleEntity) = articleDao.deleteArticle(article)
}
```

---

### Comparison for the iOS Developer
* **Boilerplate:** Unlike **Core Data**, where the `.xcdatamodeld` file handles much of the schema, **Room** requires explicit Kotlin classes and SQL annotations.
* **Threading:** Room does not allow database access on the Main Thread by default. The use of `suspend` functions and `Flow` ensures that database operations happen on background dispatchers, similar to performing tasks on a `backgroundContext` in Core Data.

---

## PR Title: feat: Implement Room persistence and Repository pattern

### Summary
The developer has introduced local storage capabilities to the **OpenSourceNews** project.

### Changes
* **Database Schema:** Created the `ArticleEntity` to map news data to SQLite tables.
* **Data Access:** Implemented the `ArticleDao` with support for reactive updates via Kotlin Flow.
* **Abstraction:** Added a `NewsRepository` to manage data coordination between the Retrofit network service and the Room database.

---
