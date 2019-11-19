package com.pbasualdo.dogs.breeds.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pbasualdo.dogs.BaseViewModel
import com.pbasualdo.dogs.breeds.data.BreedsRepository
import kotlinx.coroutines.Dispatchers

class BreedImageViewModel : BaseViewModel() {
    val repository: BreedsRepository = BreedsRepository()
    fun breedImage(breedName:String)  = liveData(Dispatchers.IO){
        dataLoading.postValue(true)
        val retrieveBreedImage= repository.getBreedImage(breedName)
        if(retrieveBreedImage.isSuccessful) {
            emit(retrieveBreedImage.body()!!.message)
            empty.postValue(false)
        }else{
            empty.postValue(true)
        }
    }
}
