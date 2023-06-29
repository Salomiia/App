package com.example.retrofitapp.ui.product_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.api.ApiClient
import com.example.retrofitapp.model.Product
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    val products = MutableLiveData<List<Product>>()

    fun fetchProduct() {
        viewModelScope.launch {
            val response = ApiClient.apiService.getProducts()
            if (response.isSuccessful) {
                products.value = response.body()?.products
            }
        }
    }
}
