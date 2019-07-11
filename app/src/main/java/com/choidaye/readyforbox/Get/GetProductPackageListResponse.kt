package com.choidaye.readyforbox.Get

import com.choidaye.readyforbox.Data.Packages

data class GetProductPackageListResponse(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : PackageData

)

data class PackageData(
    val package_count : Int,
    val packages : ArrayList<Packages>
)