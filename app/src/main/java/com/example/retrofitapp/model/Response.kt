package com.example.retrofitapp.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("products")
    val products: List<Product>,

    @SerializedName("total")
    val total: Int,

    @SerializedName("skip")
    val skip: Int,

    @SerializedName("limit")
    val limit: Int
)
