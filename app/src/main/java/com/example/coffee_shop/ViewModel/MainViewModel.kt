package com.example.coffee_shop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffee_shop.Domain.BannerModel
import com.example.coffee_shop.Domain.CategoryModel
import com.example.coffee_shop.Domain.ItemsModel
import com.example.coffee_shop.Repository.MainRepository

class MainViewModel: ViewModel() {
private val repository= MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()

    }

    fun loadPopular(): LiveData<MutableList<ItemsModel>>{
        return repository.loadPopular()
    }
    fun loadItems(categoryId: String): LiveData<MutableList<ItemsModel>>{
        return repository.loadItemCategory(categoryId)
    }
}