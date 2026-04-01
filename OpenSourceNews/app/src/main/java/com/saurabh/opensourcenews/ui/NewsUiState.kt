package com.saurabh.opensourcenews.ui

import com.saurabh.opensourcenews.data.model.Article

sealed class NewsUiState {
    object Loading : NewsUiState()
    data class Success(val articles: List<Article>) : NewsUiState()
    data class Error(val message: String) : NewsUiState()
}
