package com.choidaye.readyforbox.Get

import com.choidaye.readyforbox.Data.Packages
import com.choidaye.readyforbox.Data.Regular
import com.choidaye.readyforbox.Data.Regular_not_important

data class GetForUResultResponse (
    var status : Int,
    var success : Boolean,
    var message : String,
    var data : ForURestulData
)

data class ForURestulData(
    var pacakges : ArrayList<Packages>,
    var regular: ArrayList<Regular>,
    var regular_not_important : ArrayList<Regular_not_important>
)