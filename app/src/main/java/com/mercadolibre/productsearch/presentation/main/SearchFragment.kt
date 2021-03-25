package com.mercadolibre.productsearch.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mercadolibre.productsearch.databinding.FragmentSearchBinding
import com.mercadolibre.productsearch.domain.entities.Product
import com.mercadolibre.productsearch.presentation.base.Status
import com.mercadolibre.productsearch.presentation.base.UiStatus
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(), SearchView.OnQueryTextListener, OnProductClicked {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel by viewModel<SearchViewModel>()
    private lateinit var productListAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpObservers()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        productListAdapter = ProductListAdapter(this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = productListAdapter
        }
    }

    private fun setUpObservers() {
        binding.searchView.setOnQueryTextListener(this)
        viewModel.productsLiveData.observe(::getLifecycle, ::updateUI)
    }

    private fun updateUI(uiStatus: UiStatus<List<Product>>) {
        when (uiStatus.status) {
            Status.LOADING -> {
            }
            Status.SUCCESS -> {
                drawProducts(uiStatus.data)
            }
            Status.ERROR -> {
                showError(uiStatus.error)
            }
        }
    }

    private fun drawProducts(products: List<Product>?) {
        products?.let { items ->
            // TODO update recyclerView
            productListAdapter.updateItems(items)
            productListAdapter.notifyDataSetChanged()
        } ?: showError(Exception("No products found"))
    }

    private fun showError(error: Exception?) {
        Toast.makeText(context, error?.message, Toast.LENGTH_LONG).show()
    }

    override fun onProductClicked(item: String) {
        Toast.makeText(this.context, "lucho", Toast.LENGTH_LONG).show()
    }

    override fun onQueryTextSubmit(searchInput: String?): Boolean {
        searchInput?.let {
            viewModel.getProducts(searchInput)
        } ?: showError(Exception("lala"))
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return false
    }

}
