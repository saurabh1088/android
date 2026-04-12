package com.saurabh.opensourcenews.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

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

@Composable
fun BottomNavigation(content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}
