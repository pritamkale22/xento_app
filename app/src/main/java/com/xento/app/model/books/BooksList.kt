package com.xento.app.model.books

import com.google.gson.annotations.SerializedName

data class BooksList(
    @SerializedName("kind") val kind: String,
    @SerializedName("totalItems") val totalItems: Int,
    @SerializedName("items") val data: List<Books>
)


