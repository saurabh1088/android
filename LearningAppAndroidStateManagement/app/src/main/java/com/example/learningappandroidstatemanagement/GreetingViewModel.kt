package com.example.learningappandroidstatemanagement

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GreetingViewModel : ViewModel() {
    // 1. Private state (Backing property)
    private val _name = MutableStateFlow("")

    // 2. Public read-only state
    val name: StateFlow<String> = _name.asStateFlow()

    // 3. Action/Event function
    fun onNameChange(newName: String) {
        _name.value = newName
    }
}
