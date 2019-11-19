package com.pbasualdo.dogs.api

import com.pbasualdo.dogs.breeds.data.Breeds
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsService {

    companion object{
        const val ENDPOINT="https://dog.ceo/api/"
    }

    @GET("breeds/list/all")
    suspend fun getAllBreeds():Response<ResultsResponse<Map<String, List<String>>>>

    @GET("breed/{breed}/images/random")
    suspend fun getBreedImage(@Path("breed", encoded = true) breedName:String):Response<ResultsResponse<String>>



}