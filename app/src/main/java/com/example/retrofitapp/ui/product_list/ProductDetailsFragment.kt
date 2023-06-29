package com.example.retrofitapp.ui.product_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.retrofitapp.R

class ProductDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = arguments?.let {
            ProductDetailsFragmentArgs.fromBundle(it).product
        }

        product?.let {
            val productImage = view.findViewById<ImageView>(R.id.ivProductImage)
            val productTitle = view.findViewById<TextView>(R.id.tvProductName)
            val productPrice = view.findViewById<TextView>(R.id.tvProductPrice)
            val productDescription = view.findViewById<TextView>(R.id.tvProductDescription)

            Glide.with(this)
                .load(it.thumbnail)
                .error(R.drawable.error)
                .into(productImage)
            productTitle.text = it.title
            productPrice.text = "${it.price}$"
            productDescription.text = it.description
        }
    }
}
