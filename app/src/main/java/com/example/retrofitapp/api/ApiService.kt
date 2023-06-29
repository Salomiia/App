package com.example.retrofitapp.api

import com.example.retrofitapp.model.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): retrofit2.Response<Response>
}
