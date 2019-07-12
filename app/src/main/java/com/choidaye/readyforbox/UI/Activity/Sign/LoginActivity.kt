package com.choidaye.readyforbox.UI.Activity.Sign

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.choidaye.readyforbox.Network.NetworkService
import com.choidaye.readyforbox.Post.PostLoginResponse
import com.choidaye.readyforbox.DB.SharedPreferenceController
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.MainActivity
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //아이디 클릭 효과
        edtLoginID.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) v.setBackgroundResource(R.drawable.select_login_border)
            else v.setBackgroundResource(R.drawable.primary_login_border)
        }
        //패스워드 클릭 효과
        edtLoginPW.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) v.setBackgroundResource(R.drawable.select_login_border)
            else v.setBackgroundResource(R.drawable.primary_login_border)
        }
        //로그인 버튼 클릭 시(안 뜬 것 요구)
        btnLoginSubmit.setOnClickListener {
            val email = edtLoginID.text.toString()
            val password: String = edtLoginPW.text.toString()

            if (email == "") edtLoginID.requestFocus()
            else if (password == "") edtLoginPW.requestFocus()
            else postLoginResponse(email,password)
        }

    }
    //로그인 버튼 시 효과
    fun postLoginResponse(email: String, password: String){
        var jsonObject = JSONObject()
        jsonObject.put("email", email)
        jsonObject.put("password", password)

        val gsonObject : JsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        //val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        val postLoginResponse: Call<PostLoginResponse> =
            networkService.postLoginResponse("application/json", gsonObject)
        postLoginResponse.enqueue(object: Callback<PostLoginResponse> {
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable){
                Log.e("Login failed", t.toString())
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {
                if(response.isSuccessful){
                    if(response.body()!!.status==200){
                        val token = response.body()!!.data.token
                        SharedPreferenceController.setUserToken(applicationContext, token)
                        Log.v("token",token.toString())
                        startActivity<MainActivity>()

                    } else{
                        Log.v("response data", "서버 값 전달 실패")
                    }
                }
            }
        })
    }
}
