package com.builditcreative.myapplication.model
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.builditcreative.myapplication.api.RetrofitApi
import com.example.example.MenuItemDetail
import com.example.example.Responce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ItemViewModel:ViewModel() {

    private var itemLiveData = MutableLiveData<List<MenuItemDetail>>()
    fun getItem() {
        RetrofitApi.api.getMenu(-1,"E",23.04565431097748,72.51181852072477,1334,40818)
            .enqueue(object :Callback<Responce> {
                override fun onResponse(call: Call<Responce>, response: Response<Responce>) {
                    val menuItemDetails:MutableList<MenuItemDetail> = ArrayList()
                    for (resultItem:com.example.example.Result in response.body()?.Result!!) {
                        menuItemDetails.addAll(resultItem.menuItemDetail)
                    }
                    observeLiveData().postValue(menuItemDetails)
                }

                override fun onFailure(call: Call<Responce>, t: Throwable) {
                    Log.d("TAG", "onFailure: "+t)
                }

            })
    }
    fun observeLiveData(): MutableLiveData<List<MenuItemDetail>> {
        return itemLiveData
    }

}
