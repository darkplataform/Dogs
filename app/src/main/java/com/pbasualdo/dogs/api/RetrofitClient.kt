package com.pbasualdo.dogs.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient{
    val service by lazy{
        Retrofit.Builder()
            .baseUrl(DogsService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(DogsService::class.java)
    }
}