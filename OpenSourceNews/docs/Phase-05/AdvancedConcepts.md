# Phase-05 : Advanced Concepts

In **Phase 5**, the focus shifts to **Advanced Optimization and Polishing**. This stage transforms the application from a basic prototype into a professional-grade tool by handling large datasets efficiently and ensuring the UI adapts to system-wide settings like Dark Mode.

---

## Task 5.1: Implementing Paging 3 (Infinite Scroll)
When dealing with news feeds, fetching all articles at once is inefficient. In iOS, a developer might manually handle pagination in a `UITableView` or `UICollectionView`. In Android, the **Paging 3** library automates this by managing the data stream between the API and the UI.

* **PagingSource:** The developer creates a `NewsPagingSource` class that defines how to fetch "chunks" of data (pages) from the `NewsApiService`.
* **Pager:** A `Pager` object is configured in the `NewsRepository` to handle the transition between pages.
* **LazyColumn Integration:** The UI is updated to use `collectAsLazyPagingItems()`, allowing the **LazyColumn** (Android's `List`) to automatically trigger new network requests as the user scrolls.



---

## Task 5.2: Theming and Material 3
Modern Android apps utilize **Material 3 (M3)** for design. This is the equivalent of using **Human Interface Guidelines (HIG)** and standard SwiftUI components to ensure a native look and feel.

* **Color Schemes:** The developer defines `LightColorScheme` and `DarkColorScheme` in the `ui/theme/Color.kt` and `Theme.kt` files.
* **Dynamic Color:** On Android 12+, the developer can enable **Dynamic Color**, which extracts colors from the user's wallpaper to theme the app.
* **Adaptive UI:** The developer ensures that components like the `TopAppBar` and `Card` automatically switch colors when the system-wide Dark Mode is toggled.

---

## Task 5.3: Deep Linking & WebView Refinement
To provide a seamless reading experience, the developer refines how articles are opened.

* **Chrome Custom Tabs:** Instead of a basic `WebView`, the developer implements **Chrome Custom Tabs**. This provides a shared cookie jar with the system browser and a faster loading experience, similar to `SFSafariViewController` in iOS.
* **Deep Link Handling:** The developer configures the `NavHost` to handle incoming URLs, allowing the app to open specific articles directly from a shared link.

---
