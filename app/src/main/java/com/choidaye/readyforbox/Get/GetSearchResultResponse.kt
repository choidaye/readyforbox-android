package com.choidaye.readyforbox.Get

import com.choidaye.readyforbox.Data.Product
import com.choidaye.readyforbox.Data.ProductData

data class GetSearchResultResponse(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : ProductData
)

