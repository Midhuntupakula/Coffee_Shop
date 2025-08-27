package com.example.coffee_shop.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.coffee_shop.Adapter.CategoryAdapter
import com.example.coffee_shop.Adapter.PopularAdapter
import com.example.coffee_shop.ViewModel.MainViewModel
import com.example.coffee_shop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel= MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(binding.root)

        initBanner()
        initcategory()
        initPopular()
    }
    private fun initBanner() {
        binding.progressBarBanner.visibility= View.VISIBLE
        viewModel.loadBanner().observeForever {
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.progressBarBanner.visibility= View.GONE

        }
        viewModel.loadBanner()
    }
    private fun initcategory() {
        binding.progressBarCategory.visibility=View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.recycleViewCat.layoutManager=
                LinearLayoutManager(this@MainActivity
                    , LinearLayoutManager.HORIZONTAL,
                    false
                    )
            binding.recycleViewCat.adapter= CategoryAdapter(it)
            binding.progressBarCategory.visibility= View.GONE
            }
        viewModel.loadCategory()
        }
    private fun initPopular(){
        binding.progressBarPopular.visibility= View.VISIBLE
        viewModel.loadPopular().observeForever {
            binding.recycleViewPopular.layoutManager= GridLayoutManager(this,2)
            binding.recycleViewPopular.adapter= PopularAdapter(it)
            binding.progressBarPopular.visibility= View.GONE

        }
        viewModel.loadPopular()
    }
    }