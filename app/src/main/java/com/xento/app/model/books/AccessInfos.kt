package com.xento.app.model.books

import com.google.gson.annotations.SerializedName

data class AccessInfos (
    @SerializedName("country") val country : String,
    @SerializedName("viewability") val viewability : String,
    @SerializedName("embeddable") val embeddable : Boolean,
    @SerializedName("publicDomain") val publicDomain : Boolean,
    @SerializedName("textToSpeechPermission") val textToSpeechPermission : String,
    @SerializedName("webReaderLink") val webReaderLink : String,
    @SerializedName("accessViewStatus") val accessViewStatus : String,
    @SerializedName("quoteSharingAllowed") val quoteSharingAllowed : Boolean,
    @SerializedName("epub") val epub : Epub,
    @SerializedName("pdf") val pdf : Pdf

)
