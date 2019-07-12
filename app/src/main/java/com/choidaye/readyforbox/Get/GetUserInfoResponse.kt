package com.choidaye.readyforbox.Get

data class GetUserInfoResponse(
    var status : Int,
    var success : Boolean,
    var message: String,
    var data : UserData
)

data class UserData(
    var user_id : Int,
    var name : String,
    var email : String,
    var phone : Int,
    var address : String,
    var birth : Int,
    var gender : Int
)