package com.saurabh.opensourcenews.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object ArticleDetail : Screen("detail_screen")
    object Saved : Screen("saved_screen")
}