package com.mercadolibre.productsearch.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mercadolibre.productsearch.databinding.FragmentSearchBinding
import com.mercadolibre.productsearch.domain.entities.Products
import com.mercadolibre.productsearch.presentation.base.Status
import com.mercadolibre.productsearch.presentation.base.UiStatus
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel by viewModel<SearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getProducts("honda xr")
    }

    private fun setUpObservers() {
        viewModel.productsLiveData.observe(::getLifecycle, ::updateUI)
    }

    private fun updateUI(uiStatus: UiStatus<List<Products>>) {
        when (uiStatus.status) {
            Status.LOADING -> {}
            Status.SUCCESS -> { drawProducts(uiStatus.data)}
            Status.ERROR -> { showError()}
        }
    }

    private fun drawProducts(products: List<Products>?) {
        products?.let {
            // TODO update recyclerView
            Log.d("lucho", products.toString())
        } ?: showError()
    }

    private fun showError() {

    }

}
