package com.choidaye.readyforbox.Get


import com.choidaye.readyforbox.Data.ProductData

data class GetProductDeliveyListResponse(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : ProductData
)

