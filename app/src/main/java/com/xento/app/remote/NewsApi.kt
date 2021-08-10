package com.xento.app.remote

import com.xento.app.model.news.NewsList

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(@Query("q") q: String,
                        @Query("from") from: String,
                        @Query("sortBy") sortBy: String,
                        @Query("apiKey") apiKey: String

    ): Response<NewsList>

    //

}