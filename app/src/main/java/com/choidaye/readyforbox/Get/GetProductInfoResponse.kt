package com.choidaye.readyforbox.Get

data class GetProductInfoResponse (
    var status : Int,
    var success : Boolean,
    var message : String,
    var data : ProductInfo
)

data class ProductInfo(
    var main_img : String,
    var content : String,
    var name : String,
    var sale_ratio : Int,
    var price : Int,
    var saled_price : Int,
    var content_img : ArrayList<String>

)