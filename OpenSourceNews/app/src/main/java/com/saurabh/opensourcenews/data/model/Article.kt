package com.saurabh.opensourcenews.data.model

// The Article model representing the news content
data class Article(
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?,
    val source: Source
)
