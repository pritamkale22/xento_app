package com.xento.app.model.books

import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("id") val id : String,
    @SerializedName("kind") val kind : String,
    @SerializedName("etag") val etag : String,
    @SerializedName("selfLink") val selfLink : String,
    @SerializedName("volumeInfo") val volumeInfo : VolumeInfo,
    @SerializedName("saleInfo") val saleInfo : SalesInfo,
    @SerializedName("accessInfo") val accessInfo : AccessInfos,
    @SerializedName("searchInfo") val searchInfo : SearchInfo

)
