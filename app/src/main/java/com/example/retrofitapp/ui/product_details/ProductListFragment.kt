package com.example.retrofitapp.ui.product_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.ui.product_details.ProductListViewModel
import com.bumptech.glide.Glide

class ProductListFragment : Fragment() {

    private val viewModel: ProductListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductListAdapter { product ->
            val action = ProductListFragmentDirections
                .actionProductListFragmentToProductDetailsFragment(product)
            findNavController().navigate(action)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvProductList)
        recyclerView.adapter = adapter

        viewModel.products.observe(viewLifecycleOwner, Observer { products ->
            adapter.products = products
            adapter.notifyDataSetChanged()
        })

        viewModel.fetchProduct()
    }
}
