package com.choidaye.readyforbox.UI.Fragment.MyBox


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.JsonToken
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Get.GetUserInfoResponse
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.Mypage.MyPageDeliveryManangerActivity
import kotlinx.android.synthetic.main.fragment_my_box.*
import org.jetbrains.anko.support.v4.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MyBoxFragment : Fragment() {


    var token : String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo5LCJuYW1lIjoi7LWc64uk7JiIIiwiZW1haWwiOiJkYXllQG5hdmVyLmNvbSIsImlhdCI6MTU2Mjk4ODYwNiwiZXhwIjoxNTY0MTk4MjA2LCJpc3MiOiJqYWVzZW9uZyJ9.6hdRcGFEqFCxDNJNZbHMOQiu7ExKKi6fFpL39Ji1Y_o"
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_box, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        getUserInfoResponse(token)
        btn_fg_my_box_delivery_manage.setOnClickListener {
            startActivity<MyPageDeliveryManangerActivity>()
        }



    }

    private fun getUserInfoResponse(token: String) {

        Log.e("response","리스폰스 들어옴")



        val getUserInfoResponse : Call<GetUserInfoResponse> =
        networkService.getUserInfoResponse(token)
        getUserInfoResponse.enqueue(object : Callback<GetUserInfoResponse>{
            override fun onResponse(call: Call<GetUserInfoResponse>, response: Response<GetUserInfoResponse>) {


                    if (response.isSuccessful){

                        Log.v("response", response.message())
                        Log.v("status", response.body().toString())


                        val name : String = response.body()!!.data.name
                        val email : String = response.body()!!.data.email

                        Log.v("server","서버 값 잘 받음")
                        setMyPageView(name,email)


                    }else{
                        Log.v("TAG", "서버 값 전달 실패")
                    }
            }

            override fun onFailure(call: Call<GetUserInfoResponse>, t: Throwable) {

                Log.e("My page fail",t.toString())
            }

        })
    }




    private fun setMyPageView(name : String, email : String){
        name?.let {
            tv_mypage_user_name.text = name
        }
        email?.let {
            tv_mypage_user_email.text = email
        }



    }


}
