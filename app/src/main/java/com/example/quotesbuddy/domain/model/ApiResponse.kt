package com.example.quotesbuddy.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerializedName("slip") val slip: Slip
)