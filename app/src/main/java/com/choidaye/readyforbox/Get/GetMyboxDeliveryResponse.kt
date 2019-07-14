package com.choidaye.readyforbox.Get

import com.choidaye.readyforbox.Data.Packages
import com.choidaye.readyforbox.Data.Regularity

data class GetMyboxDeliveryResponse (
    var status : Int,
    var success : Boolean,
    var message : String,
    var data : MypageDelivery

)


data class MypageDelivery(

    var regularity : ArrayList<Regularity>,
    var packages : ArrayList<Packages>
)