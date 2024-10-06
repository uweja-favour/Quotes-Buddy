package com.example.quotesbuddy.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Slip(
    @SerializedName("id") val id: Int,
    @SerializedName("advice") val advice: String
)
