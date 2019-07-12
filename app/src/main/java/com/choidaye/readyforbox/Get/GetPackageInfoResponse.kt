package com.choidaye.readyforbox.Get

import com.choidaye.readyforbox.Data.Product

data class GetPackageInfoResponse (
    var status : Int,
    var success : Boolean,
    var message: String,
    var data : PackageInfo
)

data class PackageInfo(
    var package_id : String,
    var main_img : String,
    var name : String,
    var sale_ratio : Int,
    var price : Int,
    var saled_price : Int,
    var product : ArrayList<Product>

)