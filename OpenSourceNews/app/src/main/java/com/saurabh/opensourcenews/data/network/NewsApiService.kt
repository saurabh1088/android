package com.saurabh.opensourcenews.data.network

import com.saurabh.opensourcenews.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = "YOUR_API_KEY_HERE"
    ): NewsResponse
}