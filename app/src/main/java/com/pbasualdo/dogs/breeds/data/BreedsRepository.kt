package com.pbasualdo.dogs.breeds.data

import com.pbasualdo.dogs.api.DogsService
import com.pbasualdo.dogs.api.RetrofitClient

class BreedsRepository{
    var client : DogsService = RetrofitClient.service

    suspend fun getAllBreeds()= client.getAllBreeds()

    suspend fun getBreedImage(breedName:String) = client.getBreedImage(breedName)
}