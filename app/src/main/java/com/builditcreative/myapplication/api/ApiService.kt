package com.builditcreative.myapplication.api

import com.example.example.Responce
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @POST("restaurantmenus")
    @FormUrlEncoded
    fun getMenu(
        @Field("delivery_type_time_slots") deliveryType:Int,
        @Field("is_langauge") language: String,
        @Field("latitude") latitude: Double,
        @Field("longitude") longitude: Double,
        @Field("restaurant_id") restaurntId:Int,
        @Field("vendor_id") vendor:Int
    ): Call<Responce>
}