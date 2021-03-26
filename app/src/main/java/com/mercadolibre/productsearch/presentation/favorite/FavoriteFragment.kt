package com.mercadolibre.productsearch.presentation.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mercadolibre.productsearch.R
import com.mercadolibre.productsearch.databinding.FragmentFavoriteBinding
import com.mercadolibre.productsearch.databinding.FragmentSearchBinding

private lateinit var binding: FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {}
}
