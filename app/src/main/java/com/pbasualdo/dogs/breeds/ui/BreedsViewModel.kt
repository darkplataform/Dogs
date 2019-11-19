package com.pbasualdo.dogs.breeds.ui

import androidx.lifecycle.liveData
import com.pbasualdo.dogs.BaseViewModel
import com.pbasualdo.dogs.breeds.data.Breeds
import com.pbasualdo.dogs.breeds.data.BreedsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BreedsViewModel:BaseViewModel(){
    val repository: BreedsRepository = BreedsRepository()
    val allBreeds = liveData(Dispatchers.IO){
        dataLoading.postValue(true)
        val retrieveBreeds= repository.getAllBreeds()
        dataLoading.postValue( false)
        if(retrieveBreeds.isSuccessful) {
            emit(retrieveBreeds.body()!!.message)
            empty.postValue( false)
        }else{
            empty.postValue(true)
        }
    }
}