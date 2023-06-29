package com.example.retrofitapp.ui.product_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitapp.model.Product

class ProductDetailsViewModel : ViewModel() {
    val product = MutableLiveData<Product>()
}
