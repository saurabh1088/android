package com.example.learningappandroidstatemanagement

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GreetingViewModelTest {

    private lateinit var viewModel: GreetingViewModel
    private val testDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        // 1. Tell Kotlin to use our TestDispatcher instead of the real Android Main thread
        Dispatchers.setMain(testDispatcher)
        viewModel = GreetingViewModel()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        // 2. Clean up after the test
        Dispatchers.resetMain()
    }

    @Test
    fun `initial name should be empty string`() {
        // Assert
        assertEquals("", viewModel.name.value)
    }

    @Test
    fun `when name changes, StateFlow should emit new value`() {
        // Arrange
        val newName = "Saurabh"

        // Act
        viewModel.onNameChange(newName)

        // Assert
        assertEquals(newName, viewModel.name.value)
    }
}