package com.xento.app.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsService {

    private val BASE_URL = "https://newsapi.org/v2/";
    fun getNewsService(): NewsApi{
       return Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(NewsApi::class.java)
    }

  //


}