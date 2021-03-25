package com.mercadolibre.productsearch.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mercadolibre.productsearch.R
import com.mercadolibre.productsearch.databinding.ProductCardItemLayoutBinding
import com.mercadolibre.productsearch.domain.entities.Product

interface OnProductClicked {
    fun onProductClicked(item: String)
}

class ProductListAdapter(private val onItemClicked: OnProductClicked) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val productList = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProductCardItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context)
            ), onItemClicked)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(productList[position])
    }

    fun updateItems(newItems: List<Product>) {
        this.productList.clear()
        this.productList.addAll(newItems)
    }

    class ViewHolder(private val binding: ProductCardItemLayoutBinding, private val onProductClicked: OnProductClicked) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(product: Product) {
            binding.cardText.text = product.id
            binding.cardText2.text = product.title
            Glide.with(binding.root.context)
                .load(product.image)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background) // fixme
                .into(binding.cardImage)

            binding.root.setOnClickListener {
                onProductClicked.onProductClicked(product.id)
            }
        }
    }
}
