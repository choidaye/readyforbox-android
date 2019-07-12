package com.choidaye.readyforbox.Post

data class PostLoginResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Token
)

data class Token(
    val token : String
)