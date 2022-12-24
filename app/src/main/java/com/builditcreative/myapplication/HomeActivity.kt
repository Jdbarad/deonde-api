package com.builditcreative.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.builditcreative.myapplication.databinding.ActivityHomeBinding
import com.builditcreative.myapplication.model.ItemViewModel
import com.example.example.MenuItemDetail
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: ItemViewModel
    private lateinit var binding: ActivityHomeBinding
    private lateinit var  itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemAdapter = ItemAdapter()
        binding.itemList.layoutManager = LinearLayoutManager(this)
        (binding.itemList.layoutManager as LinearLayoutManager).isAutoMeasureEnabled = false
        binding.itemList.apply { adapter = itemAdapter }

        viewModel = ViewModelProvider(this)[ItemViewModel::class.java]
        viewModel.getItem()
        viewModel.observeLiveData().observe(this) {
            run {
                itemAdapter.setItemData(it)
            }
        }

        itemAdapter.setOnMealClickListener(object :ItemAdapter.SetOnItemClickListener{
            override fun setOnClickListener(menuItemDetail: MenuItemDetail) {
                menuItemDetail.itemName?.let {
                    Snackbar.make(binding.root,
                        it,Snackbar.LENGTH_SHORT)
                }
            }
        })

    }
}