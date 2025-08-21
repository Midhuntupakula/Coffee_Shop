package com.example.coffee_shop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffee_shop.Domain.BannerModel
import com.example.coffee_shop.Repository.MainRepository

class MainViewModel: ViewModel() {
private val repository= MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }
}