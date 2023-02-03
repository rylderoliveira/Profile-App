package com.impacta.firstappkotlin.core

import com.impacta.firstappkotlin.model.Cat
import retrofit2.Call
import retrofit2.http.GET

interface CatService {
    @GET("v1/images")
    fun getRandomCats() : Call<List<Cat>>
}