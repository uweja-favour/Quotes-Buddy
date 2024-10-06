package com.example.quotesbuddy.data.repository

import com.example.quotesbuddy.data.remote.QuotesBuddyApi
import com.example.quotesbuddy.domain.model.ApiResponse
import javax.inject.Inject

class Repository @Inject constructor(
    private val quotesBuddyApi: QuotesBuddyApi
) {
    suspend fun getAdvice(): ApiResponse {
        return quotesBuddyApi.getAdvice()
    }
}