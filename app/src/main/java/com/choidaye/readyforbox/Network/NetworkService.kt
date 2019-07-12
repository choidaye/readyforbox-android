package com.choidaye.readyforbox.Network

<<<<<<< HEAD
import com.choidaye.readyforbox.Get.*
=======
import com.choidaye.readyforbox.Get.GetForUResultResponse
import com.choidaye.readyforbox.Get.GetProductDeliveyListResponse
import com.choidaye.readyforbox.Get.GetProductPackageListResponse
>>>>>>> forYou
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
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

<<<<<<< HEAD

    //forU 결과값
=======
    //준비해봤어 결과
>>>>>>> forYou
    @GET("product/custom")
    fun getForUResultResponse(
        @Query("first") first: String,
        @Query("second") second : String,
        @Query("fifth") fifth : String,
<<<<<<< HEAD
        @Query("minprice") minprice : Int

    ) : Call<GetForUResultResponse>


    //딜리버리 상품 상세페이지
    @GET("product/regular/detail")
    fun getDeliveryDetailResponse(
        @Query("product_id") product_id : String
    ) : Call<GetDeliveryDetailResponse>


    //패키지 상품 삳세페이지
    @GET("/product/package/detail")
    fun getPackageInfoResponse(
        @Query("package_id") package_id : String
    ) : Call<GetPackageInfoResponse>


    //마이페이지 유저 정보
    @POST("/mypage/user")
    fun getUserInfoResponse()

=======
        @Query("minprice") minprice : Int,
        @Query("maxprice") maxprice : Int
    ): Call<GetForUResultResponse>
>>>>>>> forYou
}