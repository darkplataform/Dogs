package com.pbasualdo.dogs.breeds.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Breeds(
    val name: Map<String, List<String>>
                  )
