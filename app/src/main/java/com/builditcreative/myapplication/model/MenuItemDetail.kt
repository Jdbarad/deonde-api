package com.example.example

import com.google.gson.annotations.SerializedName


data class MenuItemDetail (

  @SerializedName("item_id") var itemId: String?= null,
  @SerializedName("item_name") var itemName: String? = null,
  @SerializedName("image") var image: String? = null,
  @SerializedName("item_images") var itemImages: ArrayList<ItemImages> = arrayListOf(),
  @SerializedName("quantity") var quantity: Int? = null,
  @SerializedName("time_slot") var timeSlot: String? = null,
  @SerializedName("is_sold_out") var isSoldOut: String? = null,
  @SerializedName("mrp") var mrp: Int? = null,
  @SerializedName("price") var price: Int? = null,
  @SerializedName("item_type") var itemType: String? = null,
  @SerializedName("is_featured") var isFeatured: String? = null,
  @SerializedName("is_customization") var isCustomization : Int? = null

)