package com.xento.app.model.books

import com.google.gson.annotations.SerializedName

data class PanelizationSummary (

    @SerializedName("containsEpubBubbles") val containsEpubBubbles : Boolean,
    @SerializedName("containsImageBubbles") val containsImageBubbles : Boolean

        )
