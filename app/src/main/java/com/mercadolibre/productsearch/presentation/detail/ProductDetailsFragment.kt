package com.mercadolibre.productsearch.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mercadolibre.productsearch.databinding.FragmentProductDetailsBinding


class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        // This callback will only be called when MyFragment is at least Started.

        // This callback will only be called when MyFragment is at least Started.
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
                findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToSearchFragment())
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
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
