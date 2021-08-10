package com.xento.app.model.news

import com.google.gson.annotations.SerializedName

data class NewsList(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val total: Int,
    @SerializedName("articles") val data: List<News>
)



