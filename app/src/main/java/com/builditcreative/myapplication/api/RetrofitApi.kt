package com.builditcreative.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {

    val api : ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.deonde.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}
