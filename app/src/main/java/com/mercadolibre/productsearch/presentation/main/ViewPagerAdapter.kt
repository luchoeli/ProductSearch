package com.mercadolibre.productsearch.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mercadolibre.productsearch.presentation.favorite.FavoriteFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> {
                MainHostFragment()
            }
            1 -> {
                FavoriteFragment()
            }
            else -> {
                SearchFragment()
            }
        }
    }
}
