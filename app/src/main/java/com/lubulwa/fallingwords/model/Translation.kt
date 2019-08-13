package com.lubulwa.fallingwords.model

import com.google.gson.annotations.SerializedName

data class Translation(
    @field:SerializedName("text_eng") val english: String,
    @field:SerializedName("text_spa") val spanish: String
)