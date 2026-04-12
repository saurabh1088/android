package com.saurabh.opensourcenews.di

import android.content.Context
import androidx.room.Room
import com.saurabh.opensourcenews.data.local.NewsDatabase
import com.saurabh.opensourcenews.data.network.NewsApiService
import com.saurabh.opensourcenews.data.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApiService(): NewsApiService {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            "news_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApiService, db: NewsDatabase): NewsRepository {
        return NewsRepository(api, db.getArticleDao())
    }
}
