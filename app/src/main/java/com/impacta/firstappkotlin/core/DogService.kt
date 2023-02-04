package com.impacta.firstappkotlin.core

import com.impacta.firstappkotlin.model.Dog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val TOKEN = "live_qmIrvF1AS8IKBQP4DK6mJLIwV1c46tRxaLfuyH7kv5tPnb0VhhSeHXLlB29gNVxn'"

interface DogService {

    @GET("v1/images/search?limit=10")
    suspend fun getRandomDogs(): Response<List<Dog>>

    @Headers("x-api-key: $TOKEN")
    @GET("v1/images/search")
    suspend fun getDogs(
        @Query("breed_ids") breed: String,
        @Query("limit") limit: Int,
    ): Response<List<Dog>>
}