package com.xento.app.remote

import com.xento.app.model.books.BooksList

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {

    @GET("volumes")
    suspend fun getBooks(@Query("q") q: String): Response<BooksList>

}