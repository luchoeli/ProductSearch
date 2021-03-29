package com.mercadolibre.productsearch.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mercadolibre.productsearch.R
import com.mercadolibre.productsearch.databinding.FragmentProductDetailsBinding
import com.mercadolibre.productsearch.presentation.main.SearchViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private val viewModel by sharedViewModel<SearchViewModel>()
    val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setOnBackPressed()
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToSearchFragment())
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    private fun setOnBackPressed() {
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToSearchFragment())
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(this, callback)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val product = args.product
        with(binding) {
            productDetailsTitle.text = product.title
            productDetailsPrice.text = product.price.toString()

            productDetailsAddressTitle.text = getString(R.string.product_details_address_info_section)
            productDetailsAddressScity.text = product.address?.city_name
            productDetailsAddressState.text = product.address?.state_name

            productDetailsAcceptsMp.text = product.acceptsMercadopago.toString()

            productDetailsSellerTitle.text = getString(R.string.product_details_seller_info_section)
            productDetailsSellerTotal.text = product.sellerInfo?.total.toString()
            productDetailsSellerComplete.text = product.sellerInfo?.completed.toString()
            productDetailsSellerCanceled.text = product.sellerInfo?.canceled.toString()

            // TODO navigate to custom tab seller & product ML page
            productDetailsGoSeller
            productDetailsGoToProduct
        }

        // TODO add star shaped selector to add/remove product from database.
        viewModel.addFavorite(args.product)
    }
}
