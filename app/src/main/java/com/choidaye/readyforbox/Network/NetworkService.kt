package com.choidaye.readyforbox.Network

import com.choidaye.readyforbox.Get.GetProductDeliveyListResponse
import com.choidaye.readyforbox.Get.GetProductPackageListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
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


    @GET("/product/custom")
    fun getForUResultResponse(
        @Query("first") first: String,
        @Query("second") second : String,
        @Query("fifth") fifth : String,
        @Query("minprice") minprice : Int

    )
}