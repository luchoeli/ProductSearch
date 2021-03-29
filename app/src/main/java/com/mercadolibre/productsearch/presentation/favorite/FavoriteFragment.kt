package com.mercadolibre.productsearch.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mercadolibre.productsearch.R
import com.mercadolibre.productsearch.databinding.FragmentFavoriteBinding
import com.mercadolibre.productsearch.domain.entities.Product
import com.mercadolibre.productsearch.presentation.main.OnProductClicked
import com.mercadolibre.productsearch.presentation.main.ProductListAdapter
import com.mercadolibre.productsearch.presentation.main.SearchViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class FavoriteFragment : Fragment(), OnProductClicked {

    private val viewModel by sharedViewModel<SearchViewModel>()
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var favoriteListAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        setUpObservers()
        initRecyclerView()
        super.onCreate(savedInstanceState)
    }

    private fun initRecyclerView() {
        favoriteListAdapter = ProductListAdapter(this)
        val layoutManagers = LinearLayoutManager(this.context)
        binding.favoriteRecyclerView.apply {
            layoutManager = layoutManagers
            adapter = favoriteListAdapter
        }
    }

    private fun setUpObservers() {
        viewModel.favoritesLiveData.observe(::getLifecycle, ::drawFavorites)
    }

    private fun drawFavorites(products: List<Product>?) {
        products?.let { items ->
            favoriteListAdapter.updateItems(items)
            favoriteListAdapter.notifyDataSetChanged()
        } ?: showError(Exception(getString(R.string.products_not_found)))
    }

    private fun showError(exception: Exception) {
        Toast.makeText(context, exception.message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.productsLiveData.value
    }

    override fun onProductClicked(item: Product) {
        // TODO navigate to details
        Toast.makeText(context, "product ${item.id}clicked", Toast.LENGTH_LONG).show()
    }
}
