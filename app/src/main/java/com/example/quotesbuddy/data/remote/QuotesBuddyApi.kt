package com.example.quotesbuddy.data.remote

import com.example.quotesbuddy.domain.model.ApiResponse
import com.example.quotesbuddy.util.Constants.BASE_URL
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesBuddyApi {

    @GET(BASE_URL)
    suspend fun getAdvice(): ApiResponse

}