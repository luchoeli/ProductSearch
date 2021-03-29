package com.mercadolibre.productsearch.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mercadolibre.productsearch.R
import com.mercadolibre.productsearch.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.pager
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewPagerAdapter by lazy { ViewPagerAdapter(this) }
    private val productViewModel by viewModel<SearchViewModel>()

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
                    tab.text = getString(R.string.main_activity_tab_search_text)
                }
                1 -> {
                    tab.text = getString(R.string.main_activity_tab_favorites)
                }
            }
        }.attach()
    }
}
