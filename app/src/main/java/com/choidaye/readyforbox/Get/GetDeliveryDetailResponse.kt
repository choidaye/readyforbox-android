package com.choidaye.readyforbox.Get

data class GetDeliveryDetailResponse (
    var status : Int,
    var success : Boolean,
    var message : String,
    var data : DeliveryDetail

)


data class DeliveryDetail(
    var main_img : String,
    var name : String,
    var content : String,
    var sale_ratio : Int,
    var price : Int,
    var saled_price : Int,
    var content_img : ArrayList<String>

)