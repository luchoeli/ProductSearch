package com.mercadolibre.productsearch.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.mercadolibre.productsearch.R

class MainHostFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main_host, container, false)

        val master = childFragmentManager.findFragmentById(R.id.main_nav_fragment) as NavHostFragment?
        if (master != null) {
            val navController = master.navController
            val navInflater = navController.navInflater
            val graph = navInflater.inflate(R.navigation.main_nav_graph)

            master.navController.setGraph(graph, arguments)
        }

        return rootView
    }
}

