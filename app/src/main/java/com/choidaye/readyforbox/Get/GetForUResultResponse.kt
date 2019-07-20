package com.choidaye.readyforbox.Get

import com.choidaye.readyforbox.Data.Packages
import com.choidaye.readyforbox.Data.Regular_not_Important
import com.choidaye.readyforbox.Data.Regularity

data class GetForUResultResponse (
    var status : Int,
    var success : Boolean,
    var message : String,
    var data : ForUResultData
)

data class ForUResultData(
    var packages : ArrayList<Packages>,
    var regularity: ArrayList<Regularity>,
    var regular_not_Important : ArrayList<Regular_not_Important>
)