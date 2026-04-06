package com.saurabh.opensourcenews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saurabh.opensourcenews.data.local.dao.ArticleDao
import com.saurabh.opensourcenews.data.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
}
