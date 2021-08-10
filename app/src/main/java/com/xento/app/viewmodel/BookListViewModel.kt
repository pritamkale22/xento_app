package com.xento.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xento.app.model.books.Books
import com.xento.app.remote.BooksService

import kotlinx.coroutines.*

class BookListViewModel : ViewModel() {

    val booksService = BooksService().getBooksService()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    val books = MutableLiveData<List<Books>>()
    val booksLoadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchBooks()
    }

    private fun fetchBooks() {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = booksService.getBooks("quilting")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    books.value = response.body()?.data
                    booksLoadError.value = null
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
        booksLoadError.value = ""
        loading.value = false
    }

    private fun onError(message: String) {
        booksLoadError.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}