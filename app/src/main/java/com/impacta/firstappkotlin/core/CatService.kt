package com.impacta.firstappkotlin.core

import com.impacta.firstappkotlin.model.Cat
import retrofit2.Response
import retrofit2.http.GET

interface CatService {
    @GET("v1/images/search?limit=10")
    suspend fun getRandomCats(): Response<List<Cat>>
}