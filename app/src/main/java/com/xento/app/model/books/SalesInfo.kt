package com.xento.app.model.books

import com.google.gson.annotations.SerializedName

data class SalesInfo(
    @SerializedName("country") val kind: String,
    @SerializedName("saleability") val saleability: String,
    @SerializedName("isEbook") val isEbook:Boolean
)


