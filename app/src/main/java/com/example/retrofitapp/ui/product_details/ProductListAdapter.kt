package com.example.retrofitapp.ui.product_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapp.R
import com.example.retrofitapp.model.Product

class ProductListAdapter(private val onProductClick: (Product) -> Unit) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    var products: List<Product> = emptyList()

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.ivProductImage)
        val productTitle: TextView = itemView.findViewById(R.id.tvProductName)
        val productPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val detailsButton: Button = itemView.findViewById(R.id.btnProductDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        Glide.with(holder.itemView.context)
            .load(product.thumbnail)
            .error(R.drawable.error)
            .into(holder.productImage)

        holder.productTitle.text = product.title
        holder.productPrice.text = "${product.price}$"
        holder.detailsButton.setOnClickListener {
            onProductClick(product)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}
