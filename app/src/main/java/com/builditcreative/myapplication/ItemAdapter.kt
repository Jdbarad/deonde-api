package com.builditcreative.myapplication

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.builditcreative.myapplication.databinding.RecyclerItemBinding
import com.bumptech.glide.Glide
import com.example.example.MenuItemDetail


class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private var listOfMeals = ArrayList<MenuItemDetail>()
    private lateinit var setOnMealClickListener : SetOnItemClickListener

    fun setOnMealClickListener(setOnMealClickListener: SetOnItemClickListener){
        this.setOnMealClickListener = setOnMealClickListener
    }
    fun setItemData(listOfMeals : List<MenuItemDetail>) {
        this.listOfMeals = listOfMeals as ArrayList<MenuItemDetail>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding:RecyclerItemBinding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        Glide.with(holder.itemView).load(listOfMeals[position].itemImages[0].imageName).into(holder.binding.itemImage)
        holder.binding.itemName.text= listOfMeals[position].itemName
        holder.binding.itemDescription.text = listOfMeals[position].itemId +"\n"+ listOfMeals[position].image
        holder.binding.itemPrice.text = "₹ "+listOfMeals[position].price
        holder.binding.itemQuantity.text = "Quantity: "+listOfMeals[position].quantity
    }

    override fun getItemCount(): Int {
        return listOfMeals.size
    }
    interface SetOnItemClickListener {
        fun setOnClickListener(menuItemDetail: MenuItemDetail)
    }

}
