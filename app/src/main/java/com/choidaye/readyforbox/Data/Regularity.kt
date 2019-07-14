package com.choidaye.readyforbox.Data

data class Regularity(
    var created_at : String,
    var order_id : String,
    var delivery_cycle : Int,
    var delivery_day : Int,
    var main_img : String,
    var name : String,
    var content : String,
    var count : Int,
    var aled_price : Int,
    var is_subscribed : Int

)