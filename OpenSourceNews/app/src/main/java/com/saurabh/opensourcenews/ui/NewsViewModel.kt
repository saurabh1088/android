package com.saurabh.opensourcenews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saurabh.opensourcenews.data.network.NewsApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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