package com.mercadolibre.productsearch.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mercadolibre.productsearch.R
import com.mercadolibre.productsearch.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.pager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewPagerAdapter by lazy { ViewPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pager.adapter = viewPagerAdapter
        setUpTabLayout()
    }

    private fun setUpTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Search"
                    tab.setIcon(R.drawable.ic_chevron_left)
                }
                1 -> {
                    tab.text = "Favorites"
                }
            }
        }.attach()
    }
}
