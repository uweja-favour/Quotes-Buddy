package com.example.quotesbuddy.di

import com.example.quotesbuddy.data.remote.QuotesBuddyApi
import com.example.quotesbuddy.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofitInstance(httpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl("https://api.adviceslip.com/")
            .client(httpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }


    @Provides
    @Singleton
    fun provideQuotesBuddyApi(retrofit: Retrofit): QuotesBuddyApi {
        return retrofit.create(QuotesBuddyApi::class.java)
    }

}
