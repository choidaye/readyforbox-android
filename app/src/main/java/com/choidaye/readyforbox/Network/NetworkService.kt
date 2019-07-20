package com.choidaye.readyforbox.Network


import com.choidaye.readyforbox.Get.*

import com.choidaye.readyforbox.Get.GetForUResultResponse
import com.choidaye.readyforbox.Get.GetProductDeliveyListResponse
import com.choidaye.readyforbox.Get.GetProductPackageListResponse

import com.choidaye.readyforbox.Post.PostLoginResponse
import com.choidaye.readyforbox.Post.PostSignupResponse
import com.google.gson.JsonObject

import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    //로그인 조회
    @POST("auth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type: String,
        @Body()body: JsonObject
    ): Call<PostLoginResponse>

    //회원가입
    @POST("auth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type: String,
        @Body()body: JsonObject
    ): Call<PostSignupResponse>

    //정기배송 리스트 조회
    @GET("product/regular")
    fun getProductDeliveryListResponse(
        @Query("category")  category: String,
        @Query("flag") flag : Int
    ): Call<GetProductDeliveyListResponse>


    //패키지 리스트 조회
    @GET("product/package")
    fun  getProductPackageListResponse(
        @Query("category")  category: String,
        @Query("flag") flag : Int
    ): Call<GetProductPackageListResponse>


    @GET("product/custom")
    fun getForUResultResponse(
        @Query("first") first: String,
        @Query("second") second : String,
        @Query("fifth") fifth : String,
        @Query("minprice") minprice : Int,
        @Query("maxprice") maxprice : Int

    ): Call<GetForUResultResponse>


    //딜리버리 상품 상세페이지
    @GET("product/regular/detail")
    fun getDeliveryDetailResponse(
        @Query("product_id") product_id : String
    ) : Call<GetDeliveryDetailResponse>


    //패키지 상품 상세페이지
    @GET("product/package/detail")
    fun getPackageInfoResponse(
        @Query("package_id") package_id : String
    ) : Call<GetPackageInfoResponse>


    //정기배송 상품 상세 페이지
    @GET("product/regular/detail")
    fun getProductinfoResponse(
        @Query("product_id") product_id: String
    ) : Call<GetProductInfoResponse>


    //마이페이지 유저 정보
    @GET("mypage/user")
    fun getUserInfoResponse(
        @Header("token") token : String
    ) : Call<GetUserInfoResponse>


    //마이페이지 정기배송
    @GET("mypage/order")
    fun getMypageDelivery(
        @Header("token") token : String
    ) : Call<GetMyboxDeliveryResponse>

    //검색결과
    @GET("product/regular")
    fun getSearchResult(
        @Query("search") search : String
    ) : Call<GetSearchResultResponse>




}