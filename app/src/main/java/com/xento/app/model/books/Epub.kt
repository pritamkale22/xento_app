package com.xento.app.model.books

import com.google.gson.annotations.SerializedName

data class Epub (
    @SerializedName("isAvailable") val isAvailable : Boolean
)
