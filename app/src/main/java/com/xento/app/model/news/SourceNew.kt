package com.xento.app.model.news

import com.google.gson.annotations.SerializedName

data class SourceNew(

    @SerializedName("id") val author : String?,
    @SerializedName("name") val title : String

)


