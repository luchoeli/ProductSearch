package com.mercadolibre.productsearch.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mercadolibre.productsearch.R
import com.mercadolibre.productsearch.databinding.FragmentProductDetailsBinding
import com.mercadolibre.productsearch.databinding.FragmentSearchBinding


class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val product = args.product
        with(binding) {
            productDetailsTitle.text = product.title
            productDetailsPrice.text = product.price.toString()

            productDetailsAddressTitle.text = "Address info"
            productDetailsAddressScity.text = product.address?.city_name
            productDetailsAddressState.text = product.address?.state_name

            productDetailsAcceptsMp.text = product.acceptsMercadopago.toString()

            productDetailsSellerTitle.text = "Seller info"
            productDetailsSellerTotal.text = product.sellerInfo.total.toString()
            productDetailsSellerComplete.text = product.sellerInfo.completed.toString()
            productDetailsSellerCanceled.text = product.sellerInfo.canceled.toString()


            productDetailsGoSeller
            productDetailsGoToProduct
        }

    }

}
