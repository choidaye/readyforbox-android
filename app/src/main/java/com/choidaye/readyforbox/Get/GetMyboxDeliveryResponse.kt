package com.choidaye.readyforbox.Get

import com.choidaye.readyforbox.Data.Packages
import com.choidaye.readyforbox.Data.Regular

data class GetMyboxDeliveryResponse (
    var status : Int,
    var success : Boolean,
    var message : String,
    var data : MypageDelivery

)


data class MypageDelivery(

    var regular : ArrayList<Regular>,
    var packages : ArrayList<Packages>
)