package com.xento.app.model.books

import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("title") val title : String,
    @SerializedName("subtitle") val subtitle : String,
    @SerializedName("authors") val authors : List<String>,
    @SerializedName("publisher") val publisher : String,
    @SerializedName("publishedDate") val volumeInfo : String,
    @SerializedName("description") val description : String,
    @SerializedName("industryIdentifiers") val industryIdentifiers : List<IndustryIdentifiers>,
    @SerializedName("readingModes") val readingModes : ReadingModes,
    @SerializedName("pageCount") val pageCount : Int,
    @SerializedName("printType") val printType : String,
    @SerializedName("categories") val categories : List<String>,
    @SerializedName("maturityRating") val maturityRating : String,
    @SerializedName("allowAnonLogging") val allowAnonLogging : Boolean,
    @SerializedName("contentVersion") val contentVersion : String,
    @SerializedName("panelizationSummary") val panelizationSummary : PanelizationSummary,
    @SerializedName("imageLinks") val imageLinks : ImageLinks,
    @SerializedName("language") val language : String,
    @SerializedName("previewLink") val previewLink : String,
    @SerializedName("infoLink") val infoLink : String,
    @SerializedName("canonicalVolumeLink") val canonicalVolumeLink : String
)






