package com.xento.app.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BooksService {

    private val BASE_URL = "https://www.googleapis.com/books/v1/";
    fun getBooksService(): BooksApi{
       return Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(BooksApi::class.java)
    }
}

