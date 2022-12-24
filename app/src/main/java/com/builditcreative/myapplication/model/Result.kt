package com.example.example

import com.google.gson.annotations.SerializedName


data class Result (

  @SerializedName("restaurant_menu_id") var restaurantMenuId : Int?= null,
  @SerializedName("menu_name") var menuName : String? = null,
  @SerializedName("is_display_image") var isDisplayImage : String? = null,
  @SerializedName("menu_item_detail") var menuItemDetail : ArrayList<MenuItemDetail> = arrayListOf()

)