package com.example.example

import com.google.gson.annotations.SerializedName


data class Responce (

  @SerializedName("code" ) var code: Int?= null,
  @SerializedName("item_count") var itemCount: Int?= null,
  @SerializedName("msg") var msg: String?= null,
  @SerializedName("restaurant_on_off") var restaurantOnOff : String?= null,
  @SerializedName("Result") var Result: ArrayList<Result> = arrayListOf(),
  @SerializedName("Bravges") var Bravges: ArrayList<String> = arrayListOf()

)