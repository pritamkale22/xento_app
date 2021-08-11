package com.xento.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xento.app.model.news.News
import com.xento.app.remote.NewsService
import kotlinx.coroutines.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class NewsViewModel : ViewModel() {

    val newsService = NewsService().getNewsService()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    val news = MutableLiveData<List<News>>()
    val newsLoadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchNesw()
    }

    private fun fetchNesw() {
        loading.value = true
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val currentDate = sdf.format(Date())

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

          //  everything?q=tesla&from=2021-07-10&sortBy=publishedAt&apiKey=1edb7f6f01674626ac4aea23415c60f6
            val response = newsService.getNews("tesla", currentDate, "publishedAt", "1edb7f6f01674626ac4aea23415c60f6")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    news.value = response.body()?.data
                    newsLoadError.value = null
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
        newsLoadError.value = ""
        loading.value = false
    }

    private fun onError(message: String) {
        newsLoadError.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}