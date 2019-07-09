package com.choidaye.readyforbox.Get

import com.choidaye.readyforbox.Data.Product

data class GetProductDeliveyListResponse(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : ProductData
)

data class ProductData(
    val product_count : Int,
    val product : ArrayList<Product>
)