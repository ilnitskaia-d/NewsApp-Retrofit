package com.example.newsapp.repository

import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    //from internet
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    //from internet
    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    //to room
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    //from room
    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    //from room
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}