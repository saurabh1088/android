package com.saurabh.opensourcenews.data.repository

import com.saurabh.opensourcenews.data.local.dao.ArticleDao
import com.saurabh.opensourcenews.data.local.entity.ArticleEntity
import com.saurabh.opensourcenews.data.network.NewsApiService

class NewsRepository(
    private val apiService: NewsApiService,
    private val articleDao: ArticleDao
) {
    suspend fun getRemoteNews() = apiService.getTopHeadlines()

    suspend fun saveArticle(article: ArticleEntity) = articleDao.upsert(article)

    fun getSavedNews() = articleDao.getAllArticles()

    suspend fun deleteSavedArticle(article: ArticleEntity) = articleDao.deleteArticle(article)
}
